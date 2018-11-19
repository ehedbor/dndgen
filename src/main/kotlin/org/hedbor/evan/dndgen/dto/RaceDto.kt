package org.hedbor.evan.dndgen.dto

import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Race
import org.hedbor.evan.dndgen.type.SizeCategory
import org.hedbor.evan.dndgen.util.toEnumMap
import java.lang.IllegalStateException

data class RacesDto(val races: List<RaceDto>)

/**
 * Models a [Race] as stored in YAML.
 */
data class RaceDto(
    val name: String?,
    val ability_scores: Map<String, Int>?,
    val size: String?,
    val speed: Int?,
    val languages: List<String>?,
    val entry: String?
) {
    fun toRace(): Race {
        checkNotNull(name) { "Race must have a name" }
        checkNotNull(ability_scores) { "Race '$name' must have ability scores" }
        checkNotNull(size) { "Race '$name' must have a valid size category" }
        check(speed != null && speed > 0) { "Race '$name' must have a positive speed" }
        check(languages != null && languages.isNotEmpty()) { "Race '$name' must know at least one language" }

        val abilities = ability_scores.mapKeys { entry ->
            val k = AbilityType.fromString(entry.key)
            k ?: throw IllegalStateException("'${entry.key}' is not a valid AbilityType")
        }.toEnumMap()

        for (a in AbilityType.values()) {
            abilities.putIfAbsent(a, 0)
        }

        val sizeCategory = SizeCategory.fromString(size) ?: throw IllegalStateException("'$size' is not a valid SizeCategory")

        return Race(
            name,
            abilities,
            sizeCategory,
            speed,
            languages,
            entry
        )
    }
}