package br.com.codar.google.codejam2018;

import java.util.Scanner;

public class TroubleSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {

            int size = in.nextInt();

            int[] array = new int[size];

            for (int j = 0; j < size; j++)
                array[j] = in.nextInt();

            troubleSort(array);

            int unsortedIndex = getUnsortedIndex(array);

            if (unsortedIndex == -1)
                System.out.println("Case #" + i + ": OK");
            else
                System.out.println("Case #" + i + ": " + unsortedIndex);
        }
    }

    private static void troubleSort(int[] array) {

        boolean done = false;

        while (!done) {

            done = true;

            for (int i = 0; i < array.length - 2; i++) {

                if (array[i] > array[i + 2]) {
                    trade(array, i, i + 2);
                    done = false;
                }
            }
        }
    }

    private static void trade(int[] array, int i, int j) {
        int aux = array[i];

        array[i] = array[j];
        array[j] = aux;
    }

    private static int getUnsortedIndex(int[] array) {

        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return i;

        return -1;
    }

}
