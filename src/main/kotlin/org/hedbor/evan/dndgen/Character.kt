package org.hedbor.evan.dndgen


class Character {
    companion object {
        // TODO: Change this!!
        const val proficiencyBonus = 2
    }

    var abilities: Map<AbilityType, AbilityScore> = AbilityType.values().associate { it to AbilityScore(10) }
    var savingThrows: Map<AbilityType, SavingThrow> = AbilityType.values().associate { it to SavingThrow() }
    var skills: Map<SkillType, Skill> = SkillType.values().associate { it to Skill() }


    private fun modifierFor(abilityType: AbilityType, savingThrow: SavingThrow): Int {
        val scoreModifier = abilities[abilityType]!!.modifier
        val proficiencyModifier = if (savingThrow.proficient) proficiencyBonus else 0
        return scoreModifier + proficiencyModifier
    }

    private fun modifierFor(skillType: SkillType, skill: Skill): Int {
        val scoreModifier = abilities[skillType.baseAbility]!!.modifier
        val proficiencyModifier = if (skill.proficient) proficiencyBonus else 0
        return scoreModifier + proficiencyModifier
    }

    override fun toString(): String {
        fun <K, V> format(title: String, map: Map<K, V>, entryToString: (K, V) -> String): String {
            val newLine = System.lineSeparator()

            var result = "$title$newLine"
            for ((key, value) in map) {
                result += "${entryToString(key, value)}$newLine"
            }
            result += newLine

            return result
        }

        return format("Ability Scores:", abilities) { type, score -> "$type: ${score.value} (${score.modifier})" } +
            format("Saving Throws:", savingThrows) { type, savingThrow -> "$type: ${modifierFor(type, savingThrow)}" } +
            format("Skills:", skills) { type, skill -> "$type: ${modifierFor(type, skill)}" }
    }
}