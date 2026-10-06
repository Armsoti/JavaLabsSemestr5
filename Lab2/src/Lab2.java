
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        boolean b;
        int i, result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter true or false: ");
        b = scanner.nextBoolean();

        System.out.println("Enter a number.");
        i = scanner.nextInt();

        if (b) {

            if (i <= -6) {
                result = i - 10;
            } else {
                result = i + 1;
            }
        } else {
            if (i < 8) {
                result = i - 1;
            } else {
                result = i + 10;
            }
        }

        System.out.println("Результат: " + result);
        scanner.close();
    }
}
