import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab3 {

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

    public static void saveResult(FileWriter writer, int result) throws IOException {
        System.out.println(result);
        writer.write(result + System.lineSeparator());
    }

    public static void processFile(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);

        try (Scanner scanner = new Scanner(inputFile);
                FileWriter writer = new FileWriter(outputPath)) {

            while (scanner.hasNext()) {
                if (scanner.hasNextBoolean()) {
                    boolean b = scanner.nextBoolean();

                    if (scanner.hasNextInt()) {
                        int i = scanner.nextInt();
                        int result = calculate(b, i);
                        saveResult(writer, result);
                    } else {
                        System.out.println("Помилка: очікувалося ціле число.");
                        scanner.next();
                    }
                } else {
                    System.out.println("Помилка: очікувалося логічне значення (true/false).");
                    scanner.next();
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка роботи з файлами: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        processFile("input.txt", "output.txt");
    }
}