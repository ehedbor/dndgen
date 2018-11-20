package org.hedbor.evan.dndgen.type


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
data class Race(
    val name: String,
    val abilityScores: Map<AbilityType, Int>,
    val size: SizeCategory,
    val speed: Int,
    val languages: List<Language>,
    val entry: String?
)