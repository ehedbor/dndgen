package org.hedbor.evan.dndgen

import org.hedbor.evan.dndgen.type.*
import org.hedbor.evan.dndgen.util.characterSheet
import org.hedbor.evan.dndgen.util.d
import java.util.*

fun main(args: Array<String>) {
    val console = Scanner(System.`in`)

    println("D&D Character Generator:")

    // Get basic information
    val playerName = console.promptUntil("Your name? ") { it.isNotBlank() }
    val characterName = console.promptUntil("Character name? ") { it.isNotBlank() }
    // TODO: parse alignments
    println("Alignment? True Neutral")
    val alignment = Alignment.TRUE_NEUTRAL

    // Generate ability scores
    // TODO have an option to use existing scores
    var rolls = List(7) { 3.d(6) }.sortedDescending()
    val abilities = mutableMapOf<AbilityType, Int>()
    println("Generated these ability scores: $rolls")
    println()

    // Select scores for each type of ability
    for (abilityType in AbilityType.values()) {
        println("Available scores: $rolls")

        val score = console.promptUntil("$abilityType: ",
            convert = { it.toIntOrNull() },
            predicate = { it != null && rolls.contains(it) }
        )!!
        rolls -= score
        abilities[abilityType] = score

        println()
    }

    // TODO ask for proficiencies

    // Generate and display the character sheet
    val characterSheet = characterSheet {
        this.playerName = playerName
        this.characterName = characterName
        this.alignment = alignment
        this.abilities = abilities
    }
    println(characterSheet)
}



fun Scanner.promptStringUntil(prompt: String, predicate: (String) -> Boolean): String {
    print(prompt)
    var input = this.nextLine()
    while (!predicate(input)) {
        print("Try again: ")
        input = this.nextLine()
    }
    return input
}

fun Scanner.promptIntUntil(prompt: String, predicate: (Int?) -> Boolean): Int? {
    print(prompt)
    var input = this.nextLine().toIntOrNull()
    while (!predicate(input)) {
        print("Try again: ")
        input = this.nextLine().toIntOrNull()
    }

    return input
}

fun <T: Any> Scanner.promptUntil(prompt: String, convert: (String) -> T?, predicate: (T?) -> Boolean): T? {
    print(prompt)
    var input = convert(this.nextLine())
    while (!predicate(input)) {
        print("Try again: ")
        input = convert(this.nextLine())
    }

    return input
}

fun Scanner.promptUntil(prompt: String, predicate: (String) -> Boolean): String {
    print(prompt)
    var input = this.nextLine()
    while (!predicate(input)) {
        print("Try again: ")
        input = this.nextLine()
    }

    return input
}

// TODO: make a test case for this
fun testBuilder() {
        val sheet = characterSheet {
        characterName = "Bob the Mighty"
        playerName = "Bobitha"
        alignment = Alignment.LAWFUL_GOOD
        abilities = mutableMapOf(
            AbilityType.STRENGTH to 18,
            AbilityType.DEXTERITY to 12,
            AbilityType.CONSTITUTION to 17,
            AbilityType.INTELLIGENCE to 7,
            AbilityType.WISDOM to 9,
            AbilityType.CHARISMA to 14
        )
        savingThrows = mutableMapOf(
            AbilityType.STRENGTH to true,
            AbilityType.CONSTITUTION to true
        )
        skills = mutableMapOf(
            SkillType.ATHLETICS to true,
            SkillType.PERSUASION to true,
            SkillType.PERCEPTION to true,
            SkillType.SURVIVAL to true
        )
    }
    println(sheet)
}