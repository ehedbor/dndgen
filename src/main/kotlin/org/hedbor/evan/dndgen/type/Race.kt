package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.type.AbilityType.*
import org.hedbor.evan.dndgen.type.Alignment.*
import org.hedbor.evan.dndgen.type.Language.*



sealed class Race(
    open val scoreIncreases: Map<AbilityType, Int>,
    open val reccomendedAlignments: List<Alignment>,
    open val size: SizeCategory = SizeCategory.MEDIUM,
    open val speed: Int = 30,
    open val languageCount: Int = 2,
    open val reccommendedLanguages: List<Language>
) {
    abstract class Dwarf : Race(
        scoreIncreases = mapOf(
            CONSTITUTION to 2
        ),
        reccomendedAlignments = listOf(
            LAWFUL_GOOD,
            NEUTRAL_GOOD,
            LAWFUL_NEUTRAL
        ),
        speed = 25,
        reccommendedLanguages = listOf(COMMON, DWARVISH)
    )

    object HillElf : Dwarf() {
        override val scoreIncreases = super.scoreIncreases + mapOf(WISDOM to 1)
    }

    object MountainElf : Dwarf() {
        override val scoreIncreases = super.scoreIncreases + mapOf(STRENGTH to 2)
    }

    abstract class Elf : Race(
        scoreIncreases = mapOf(
            DEXTERITY to 2
        ),
        reccomendedAlignments = listOf(
            CHAOTIC_GOOD,
            NEUTRAL_GOOD,
            CHAOTIC_NEUTRAL
        ),
        reccommendedLanguages = listOf(COMMON, ELVISH)
    )

    object HighElf : Elf() {
        override val scoreIncreases = super.scoreIncreases + mapOf(INTELLIGENCE to 1)
        override val languageCount = super.languageCount + 1
    }

    object WoodElf : Elf() {
        override val scoreIncreases = super.scoreIncreases + mapOf(WISDOM to 1)
    }

    object DarkElf : Elf() {
        override val scoreIncreases = super.scoreIncreases + mapOf(CHARISMA to 1)
        override val reccomendedAlignments = listOf(
            CHAOTIC_EVIL,
            NEUTRAL_EVIL,
            CHAOTIC_NEUTRAL
        )
    }

    abstract class Halfling : Race(
        scoreIncreases = mapOf(
            DEXTERITY to 2
        ),
        reccomendedAlignments = listOf(
            LAWFUL_GOOD,
            LAWFUL_NEUTRAL,
            NEUTRAL_GOOD
        ),
        reccommendedLanguages = listOf(COMMON, HALFLING)
    )

    object StoutHalfling : Halfling() {
        override val scoreIncreases = super.scoreIncreases + mapOf(CONSTITUTION to 1)
    }

    object LightfootHalfling : Halfling() {
        override val scoreIncreases = super.scoreIncreases + mapOf(CHARISMA to 1)
    }

    object Human : Race(
        scoreIncreases = mapOf(
            STRENGTH to 1,
            DEXTERITY to 1,
            CONSTITUTION to 1,
            INTELLIGENCE to 1,
            WISDOM to 1,
            DEXTERITY to 1
        ),
        reccomendedAlignments = listOf(
            LAWFUL_GOOD,
            NEUTRAL_GOOD,
            CHAOTIC_GOOD,
            LAWFUL_NEUTRAL,
            TRUE_NEUTRAL,
            CHAOTIC_NEUTRAL,
            LAWFUL_EVIL,
            NEUTRAL_EVIL,
            CHAOTIC_EVIL
        ),
        reccommendedLanguages = listOf(COMMON)
    )

    object Dragonborn : Race(
        scoreIncreases = mapOf(
            STRENGTH to 2,
            CHARISMA to 1
        ),
        reccomendedAlignments = listOf(
            LAWFUL_GOOD,
            NEUTRAL_GOOD,
            CHAOTIC_GOOD,
            LAWFUL_EVIL,
            NEUTRAL_EVIL,
            CHAOTIC_EVIL
        ),
        reccommendedLanguages = listOf(COMMON, DRACONIC)
    )

    abstract class Gnome : Race(
        scoreIncreases = mapOf(
            INTELLIGENCE to 2
        ),
        reccomendedAlignments = listOf(
            LAWFUL_GOOD,
            NEUTRAL_GOOD,
            CHAOTIC_GOOD
        ),
        size = SizeCategory.SMALL,
        speed = 25,
        reccommendedLanguages = listOf(COMMON, GNOMISH)
    )

    object ForestGnome : Gnome() {
        override val scoreIncreases = super.scoreIncreases + mapOf(DEXTERITY to 1)
    }

    object RockGnome : Gnome() {
        override val scoreIncreases = super.scoreIncreases + mapOf(CONSTITUTION to 1)
    }

    object HalfElf : Race(
        scoreIncreases = mapOf(
            CHARISMA to 2
            // TODO: Implement "two other ability scores of your choice increase by 1."
        ),
        reccomendedAlignments = listOf(
            CHAOTIC_GOOD,
            CHAOTIC_NEUTRAL,
            CHAOTIC_EVIL
        ),
        languageCount = 3,
        reccommendedLanguages = listOf(COMMON, ELVISH)
    )

    object HalfOrc : Race(
        scoreIncreases = mapOf(
            STRENGTH to 2,
            CONSTITUTION to 1
        ),
        reccomendedAlignments = listOf(
            CHAOTIC_EVIL,
            CHAOTIC_NEUTRAL
        ),
        reccommendedLanguages = listOf(COMMON, ORC)
    )

    // TODO: add tiefling
}