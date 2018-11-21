package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.type.AbilityType.*
import org.hedbor.evan.dndgen.type.SizeCategory.MEDIUM
import org.hedbor.evan.dndgen.util.enumMapOf


/**
 * Models a playable race in D&D.
 *
 * @param name The name of the race.
 * @param abilityScores The ability score increases associated with this race.
 * @param size The size of the race.
 * @param speed The speed of the race, in feet per turn.
 * @param languages The known languages of this race. Every race knows at least two languages, but these ones are granted implicitly.
 * @param entry A description of the traits associated with this race in text form.
 */
sealed class Race(
    val name: String,
    val abilityScores: Map<AbilityType, Int>,
    val size: SizeCategory,
    val speed: Int,
    val languages: List<Language>,
    val entry: String?
) {
    object Human : Race(
        name = "Human",
        abilityScores = enumMapOf(
            STRENGTH to 1,
            DEXTERITY to 1,
            CONSTITUTION to 1,
            INTELLIGENCE to 1,
            WISDOM to 1,
            CHARISMA to 1
        ),
        size = MEDIUM,
        speed = 30,
        languages = listOf("Common"),
        entry = """
            Human Traits:
            It's hard to make generalizations about humans, but
            your human character has these traits.
              Ability Score Increase. Your ability scores each
            increase by 1.
              Age. Humans reach adulthood in their late teens and
            live less than a century.
              Alignment. Humans tend toward no
            particular alignment. The best and the worst are
            found among them.
              Size. Humans vary widely in height and build, from
            barely 5 feet to well over 6 feet tall. Regardless of your
            position in that range, your size is Medium.
              Speed. Your base walking speed is 30 feet.
              Languages. You can speak, read, and write Common
            and one extra language of your choice. Humans typically
            learn the languages of other peoples they deal with,
            including obscure dialects. They are fond of sprinkling
            their speech with words borrowed from other tongues:
            Orc curses, Elvish musical expressions, Dwarvish
            military phrases, and so on.
        """.trimIndent()
    )
}