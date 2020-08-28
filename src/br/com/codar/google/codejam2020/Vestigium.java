package br.com.codar.google.codejam2020;

import java.util.*;

public class Vestigium {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        for (int i = 1; i <= cases; i ++) {

            Integer n = in.nextInt();

            int matrixTrace = 0;
            int repeatedElementsRows = 0;
            int repeatedElementsColumns = 0;

            int[][] matrix = new int[n][n];

            for (int a = 0; a < n; a++) {

                boolean repeatedFound = false;
                Map<Integer, Boolean> columnNumbers = new HashMap<>();

                for (int b = 0; b < n; b++) {

                    matrix[a][b] = in.nextInt();

                    if (a == b)
                        matrixTrace += matrix[a][b];

                    if (!repeatedFound && columnNumbers.get(matrix[a][b]) != null) {
                        repeatedElementsRows++;
                        repeatedFound = true;
                    }

                    columnNumbers.put(matrix[a][b], true);
                }
            }

            for (int b = 0; b < n; b++) {

                Map<Integer, Boolean> columnNumbers = new HashMap<>();

                for (int a = 0; a < n; a++) {

                    if (columnNumbers.get(matrix[a][b]) != null) {
                        repeatedElementsColumns++;
                        break;
                    }
                    columnNumbers.put(matrix[a][b], true);
                }
            }

            System.out.format("Case #%d: %d %d %d\n", i, matrixTrace, repeatedElementsRows, repeatedElementsColumns);
        }
    }
}
