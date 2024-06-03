import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try(ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("D:\\file.txt")); ObjectInputStream ois = new ObjectInputStream((new FileInputStream("D:\\file.txt")))){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число");
            double x = scanner.nextDouble();
            Calc calc = new Calc(x);
            double result = calc.Calculation();
            String input = "";
            while (!input.equals("exit")){
                System.out.println("Введите save или upload");
                input = scanner.next();
                if (input.equals("save")){
                    Calc object = new Calc(x);
                    obs.writeObject(x);
                    System.out.println("Успешно сохранено");
                } else if (input.equals("upload")) {
                    Calc object = new Calc(x);
                    ois.readObject();
                    double y = object.x;
                    double z = object.Calculation();
                    System.out.println(y);
                    System.out.println(z);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Calc implements Serializable {
    double x;
    Calc(double x) {
        this.x = x;
    }
    public double Calculation() {
        double y = x - Math.sin(x);
        return y;
    }

}


