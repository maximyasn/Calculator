import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

class Program {
    public static void main(String[] args) throws FileNotFoundException {
        File fileIn = new File("src/input.txt");
        File fileOut = new File("src/output.txt");
        PrintWriter pw = new PrintWriter(fileOut);

        Scanner sc = new Scanner(fileIn);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        sc.close();
        long a = 0;
        long b = 0;
        try {
            a = Long.parseLong(str[0]);
            b = Long.parseLong(str[2]);
        } catch (NumberFormatException exc) {
            pw.println("Error! Not number");
        } catch (ArrayIndexOutOfBoundsException exc) {
            pw.println("Out of bounds");

        }
        try {
            if (Objects.equals(str[1], "*"))
                pw.println((double) a * b);
            else if (Objects.equals(str[1], "+"))
                pw.println((double) a + b);
            else if (Objects.equals(str[1], "-"))
                pw.println((double) a - b);
            else if (Objects.equals(str[1], "/")) {
                if (str[2].equals("0")) throw new ArithmeticException();
                else pw.println((double) a / b);
            } else throw new InputMismatchException();
        } catch (InputMismatchException e) {
            pw.println("Operation Error!");
        } catch (ArithmeticException e) {
            pw.println("Error! Division by zero");
        }
        pw.close();
    }
}