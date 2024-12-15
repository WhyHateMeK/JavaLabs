package lab1;

import java.util.Arrays;

/**
 * Клас Lab1Task реалізує операції з матрицями.
 */
public class Lab1Task {

    /**
     * Додає дві матриці однакових розмірів.
     *
     * @param A перша матриця
     * @param B друга матриця
     * @return матриця, що є сумою A і B
     * @throws IllegalArgumentException якщо матриці null або їх розміри не збігаються
     */
    public static double[][] addMatrices(double[][] A, double[][] B) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("Матриці не можуть бути null.");
        }
        int numRows = A.length;
        int numCols = A[0].length;
        for (double[] row : A) {
            if (row.length != numCols) {
                throw new IllegalArgumentException("Матриця A має нерівні рядки.");
            }
        }
        for (double[] row : B) {
            if (row.length != numCols) {
                throw new IllegalArgumentException("Матриця B має нерівні рядки.");
            }
        }
        if (B.length != numRows || B[0].length != numCols) {
            throw new IllegalArgumentException("Розміри матриць A і B не збігаються.");
        }

        double[][] C = new double[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /**
     * Обчислює та виводить суму найбільших елементів у парних стовпцях
     * і найменших елементів у непарних стовпцях матриці.
     *
     * @param C матриця, з якою виконуються обчислення
     * @throws IllegalArgumentException якщо матриця C null або порожня
     */
    public static void calculateAndPrintResults(double[][] C) {
        if (C == null || C.length == 0 || C[0].length == 0) {
            throw new IllegalArgumentException("Матриця C не може бути null або порожньою.");
        }

        int numRows = C.length;
        int numCols = C[0].length;
        double sumMaxEven = 0; // Парні стовпці (2, 4, ...)
        double sumMinOdd = 0;  // Непарні стовпці (1, 3, ...)

        for (int j = 0; j < numCols; j++) {
            // j + 1 використовується для парності за  нумерацією (1, 2, 3, ...)
            double extreme = ((j + 1) % 2 == 0)
                    ? Double.NEGATIVE_INFINITY
                    : Double.POSITIVE_INFINITY;
            for (int i = 0; i < numRows; i++) {
                if ((j + 1) % 2 == 0) { // Парні стовпці
                    extreme = Math.max(extreme, C[i][j]);
                } else { // Непарні стовпці
                    extreme = Math.min(extreme, C[i][j]);
                }
            }
            if ((j + 1) % 2 == 0) {
                sumMaxEven += extreme;
            } else {
                sumMinOdd += extreme;
            }
        }

        System.out.println("Сума найбільших елементів у стовпцях з парними номерами: " + sumMaxEven);
        System.out.println("Сума найменших елементів у стовпцях з непарними номерами: " + sumMinOdd);
    }
}
