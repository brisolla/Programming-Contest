package br.com.codar.google.codejam2019

import java.util.*

fun main() {

    val input = Scanner(System.`in`)

    val cases = input.nextInt()

    for (c in 0 until cases) {

        input.nextInt()

        var result = input.next()

        print("Case #" + (c + 1) + ": ")

        for (letter in result) {
            if (letter == 'S')
                print("E")
            else
                print("S")
        }
        println()
    }
}