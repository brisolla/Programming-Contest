package br.com.codar.google.codejam2018;

import java.util.Scanner;

public class GoGopher {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {

            int[][] arena = new int[1000][1000];

            int minArea = in.nextInt();

            int x = 3;
            int y = 3;

            while (true) {

                System.out.println(x + " " + y);

                int diggedX = in.nextInt();
                int diggedY = in.nextInt();

                if (diggedX == 0 && diggedY == 0)
                    break;

                if (diggedX == -1 && diggedY == -1)
                    break;

                arena[diggedX][diggedY] = 1;

                if(isNeighborFilled(arena, x, y))
                    x++;
            }
        }
    }

    private static boolean isNeighborFilled(int[][] arena, int x, int y) {

        if (arena[x - 1][y - 1] != 1)
            return false;

        if (arena[x - 1][y] != 1)
            return false;

        if (arena[x - 1] [y + 1] != 1)
            return false;

        if (arena[x][y - 1] != 1)
            return false;

        if (arena[x][y] != 1)
            return false;

        if (arena[x][y + 1] != 1)
            return false;

        if (arena[x + 1][y - 1] != 1)
            return false;

        if (arena[x + 1][y] != 1)
            return false;

        if (arena[x + 1][y + 1] != 1)
            return false;

        return true;
    }

}

