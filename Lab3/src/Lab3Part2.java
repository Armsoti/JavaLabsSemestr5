import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас для виконання лабораторної роботи №3 (Частина 2, Варіант 4).
 * Забезпечує читання конфігураційного файлу із зазначеною кількістю наборів даних,
 * виконання обчислень за заданим алгоритмом та збереження результатів.
 *
 * @author Дарія Щербань
 * @version 1.0
 */
public class Lab3Part2 {

    /**
     * Обчислює результат за розгалуженим алгоритмом варіанта 4.
     *
     * @param b булевий параметр вибору гілки алгоритму
     * @param i цілочисельний вхідний параметр
     * @return ціле число це результат обчислень відповідно до значень параметрів
     */
    public static int calculate(boolean b, int i) {
        if (b) {
            if (i <= -6) {
                return i - 10;
            } else {
                return i + 1;
            }
        } else {
            if (i < 8) {
                return i - 1;
            } else {
                return i + 10;
            }
        }
    }

    /**
     * Головний метод програми, який здійснює відкриття файлів,
     * зчитування кількості наборів, послідовну обробку даних у циклі
     * та запис результатів у вихідний файл і консоль.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        File configFile = new File("config.txt");
        File outputFile = new File("output.txt");

        try (Scanner scanner = new Scanner(configFile);
             FileWriter writer = new FileWriter(outputFile)) {

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Number of test sets is missing at the start of the file.");
                return;
            }

            int count = scanner.nextInt();

            for (int k = 1; k <= count; k++) {
                if (scanner.hasNextBoolean()) {
                    boolean b = scanner.nextBoolean();

                    if (scanner.hasNextInt()) {
                        int i = scanner.nextInt();
                        int result = calculate(b, i);

                        System.out.println("Set " + k + ": " + result);
                        writer.write("Set " + k + ": " + result + System.lineSeparator());
                    } else {
                        System.out.println("Error: Expected int in set " + k + ".");
                        scanner.next();
                    }
                } else {
                    System.out.println("Error: Expected boolean in set " + k + ".");
                    scanner.next();
                }
            }

        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }
    }
}