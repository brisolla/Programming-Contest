package br.com.codar.google.codejam2019

import java.util.*

fun main() {

    val input = Scanner(System.`in`)

    val cases = input.nextInt()

    for (case in 1..cases) {

        var responseA = ""
        var responseB = ""

        var responseAHasFirstNumber = false

        val n = input.next()

        n.toCharArray().forEachIndexed { _, c ->

            if (c == '4') {
                responseAHasFirstNumber = true
                responseA += 1
                responseB += 3
            } else {
                if (responseAHasFirstNumber)
                    responseA += 0
                responseB += c
            }
        }

        println("case #$case: $responseA $responseB")
    }
}