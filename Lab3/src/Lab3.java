import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас для виконання лабораторної роботи №3 (Частина 1, Варіант 4).
 * Забезпечує читання пар вхідних даних з файлу input.txt,
 * їх обробку за розгалуженим алгоритмом та збереження результатів у файл output.txt і консоль.
 *
 * @author Дарія Щербань
 * @version 1.0
 */
public class Lab3 {

    /**
     * Обчислює значення результату відповідно до заданого алгоритму варіанта 4.
     *
     * @param b логічний прапорець вибору гілки розгалуження
     * @param i цілочисельний вхідний параметр
     * @return розраховане ціле число згідно з умовами варіанта
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
     * Виводить результат обчислення в консоль та записує його у вихідний файл.
     *
     * @param writer потік символьного запису у файл
     * @param result обчислене числове значення
     * @throws IOException якщо виникає помилка операції запису у файл
     */
    public static void saveResult(FileWriter writer, int result) throws IOException {
        System.out.println(result);
        writer.write(result + System.lineSeparator());
    }

    /**
     * Відкриває вхідний файл, послідовно читає пари даних із валідацією типів,
     * передає їх на розрахунок та зберігає отримані результати.
     *
     * @param inputPath  шлях до текстового файлу з вхідними даними
     * @param outputPath шлях до файлу для збереження результатів
     */
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
                        System.out.println("Error: Expected an integer.");
                        scanner.next();
                    }
                } else {
                    System.out.println("Error: Expected a boolean (true/false).");
                    scanner.next();
                }
            }

        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }
    }

    /**
     * Точка входу в програму. Запускає обробку файлів input.txt та output.txt.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        processFile("input.txt", "output.txt");
    }
}