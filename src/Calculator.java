import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

class Program {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Scanner sc = new Scanner(file);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        sc.close();
        long a;
        long b;
        try {
            a = Long.parseLong(str[0]);
            b = Long.parseLong(str[2]);
        } catch (NumberFormatException exc) {
            System.out.println("Error! Not number");
            return;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Out of bounds");
            return;
        }
        try {
            if (Objects.equals(str[1], "*"))
                System.out.println((double) a * b);
            else if (Objects.equals(str[1], "+"))
                System.out.println((double) a + b);
            else if (Objects.equals(str[1], "-"))
                System.out.println((double) a - b);
            else if (Objects.equals(str[1], "/")) {
                if (str[2].equals("0")) throw new ArithmeticException();
                else System.out.println((double) a / b);
            } else throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Operation Error!");
        } catch (ArithmeticException e) {
            System.out.println("Error! Division by zero");
        }
    }
}