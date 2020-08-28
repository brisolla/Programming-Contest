package br.com.codar.google.codejam2018;

import java.util.Scanner;

public class SavingTheUniverseAgain {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {

            int shield = in.nextInt();

            String code = in.next();

            if ( isImpossible(code, shield) ) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");

            } else {

                int swipes = 0;

                while (damage(code) > shield) {
                    code = swipeCode(code);
                    swipes++;
                }

                System.out.println("Case #" + i + ": " + swipes);
            }
        }
    }

    private static boolean isImpossible(String code, int shield) {

        int shotsCount = 0;

        for (char c : code.toCharArray())
            if (c == 'S')
                shotsCount++;

        if (shotsCount > shield)
            return true;

        return false;
    }

    private static int damage(String code) {

        int totalDamage = 0;
        int currentDamage = 1;

        for (char c : code.toCharArray()) {

            if (c == 'S')
                totalDamage += currentDamage;
            else
                currentDamage *= 2;
        }

        return totalDamage;
    }

    private static String swipeCode(String code) {

        char[] codeArray = code.toCharArray();

        char lastIndex = 'X';

        if (codeArray[0] == 'C')
            lastIndex = 'C';
        else
            lastIndex = 'S';

        for (int i = 1; i < codeArray.length; i++) {

            if (lastIndex == 'C' && codeArray[i] == 'S') {
                trade(codeArray, i, i - 1);
                break;
            }
            lastIndex = codeArray[i];
        }

        String newCode = "";

        for (char c : codeArray)
            newCode = newCode + c;

        return newCode;
    }

    private static void trade(char[] codeArray, int i, int j) {
        char aux = codeArray[i];

        codeArray[i] = codeArray[j];
        codeArray[j] = aux;
    }
}
