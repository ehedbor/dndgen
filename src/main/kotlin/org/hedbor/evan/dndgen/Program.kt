package org.hedbor.evan.dndgen

import java.util.*


fun main(args: Array<String>) {
    val console = Scanner(System.`in`)
    val characterSheet = CharacterSheet()

    // roll 3d6 7 times and remove the lowest score
    var rolls = List(7) { 3.d(6) }
        .sortedDescending()
        .slice(0 until 6)

    println("D&D Character Generator:")
    println("Generated these ability scores: $rolls")
    println()

    for (ability in characterSheet.abilities) {
        println("Available scores: $rolls")

        val score = console.repeatUntilInt("${ability.type}: ") { it != null && rolls.contains(it) }!!
        ability.value = score
        rolls -= score

        println()
    }

    println(characterSheet)
}

fun Scanner.repeatUntilInt(prompt: String, predicate: (Int?) -> Boolean): Int? {
    print(prompt)
    var input = this.nextLine().toIntOrNull()
    while (!predicate(input)) {
        print("Try again: ")
        input = this.nextLine().toIntOrNull()
    }

    return input
}