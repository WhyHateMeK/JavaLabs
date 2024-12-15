package lab1;

import java.util.Arrays;

/**
 * Клас для тестування операцій з матрицями.
 * Обчислює суму двох матриць та виконує додаткові розрахунки.
 */
public class Lab1Main {
    public static void main(String[] args) {
        // Матриця A
        double[][] A = {
                {5.0, 8.0, 3.0},
                {2.0, 1.0, 7.0},
                {4.0, 6.0, 9.0}
        };

        // Матриця B
        double[][] B = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        try {
            // Додавання матриць
            double[][] C = Lab1Task.addMatrices(A, B);
            System.out.println("Матриця C = A + B:");

            // Вивід матриці C
            for (double[] row : C) {
                System.out.println(Arrays.toString(row));
            }

            // Обчислення та вивід результатів
            Lab1Task.calculateAndPrintResults(C);

        } catch (Exception e) {
            // Обробка винятків
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }
}
