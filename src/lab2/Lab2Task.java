package lab2;

import java.util.Scanner;

/**
 * Клас Lab2Task виконує обробку тексту: у кожному слові видаляє всі
 * попередні входження останньої літери цього слова (незалежно від регістру).
 */
public class Lab2Task {

    /**
     * Основний метод для виконання обробки тексту.
     */
    public void action() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть текст: ");
            String inputText = scanner.nextLine();

            String[] words = inputText.split(" ");
            String result = "";

            for (String word : words) {
                if (!word.isEmpty()) {
                    char lastLetter = word.charAt(word.length() - 1);
                    String lowerLastLetter = String.valueOf(lastLetter).toLowerCase();
                    String modifiedWord = "";

                    for (int i = 0; i < word.length(); i++) {
                        char currentChar = word.charAt(i);
                        String lowerCurrentChar = String.valueOf(currentChar).toLowerCase();

                        // Додаємо символ, якщо це не попереднє входження останньої літери
                        if (!lowerCurrentChar.equals(lowerLastLetter) || i == word.length() - 1) {
                            modifiedWord += currentChar;
                        }
                    }

                    result += modifiedWord + " ";
                }
            }

            System.out.println("Результат: " + result.trim());
        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Точка входу в програму.
     */
    public static void main(String[] args) {
        Lab2Task task = new Lab2Task();
        task.action();
    }
}