package org.hedbor.evan.dndgen

import java.util.*


fun main(args: Array<String>) {
    val console = Scanner(System.`in`)
    val characterSheet = Character()

    // roll 3d6 7 times and remove the lowest score
    var rolls = List(7) { 3.d(6) }
        .sortedDescending()
        .slice(0 until 6)

    println("D&D Character Generator:")
    println("Generated these ability scores: $rolls")

    for (ability in AbilityType.values()) {
        val scoreUsed = console.repeatUntilInt("$ability: ") { it != null && rolls.contains(it) }!!
        rolls -= scoreUsed
        characterSheet.abilities += ability to AbilityScore(scoreUsed)
    }

    println("Character sheet:")
    println()
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