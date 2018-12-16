package org.hedbor.evan.dndgen

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableMap
import org.hedbor.evan.dndgen.score.Ability
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Score
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.*
import org.hedbor.evan.dndgen.util.expToLevel
import tornadofx.getValue
import tornadofx.integerBinding
import tornadofx.observable
import tornadofx.setValue
import kotlin.reflect.KClass


/**
 * Represents a D&D character's information.
 */
@Suppress("MemberVisibilityCanBePrivate")
class CharacterSheet {
    val raceProperty = SimpleObjectProperty<Race>()
    var race: Race? by raceProperty

    val abilitiesProperty = SimpleMapProperty<AbilityType, Ability>(generateDefaults { Ability(this, it, 10) })
    var abilities: ObservableMap<AbilityType, Ability>? by abilitiesProperty

    val savingThrowsProperty = SimpleMapProperty<AbilityType, SavingThrow>(generateDefaults { SavingThrow(this, it) })
    var savingThrows: ObservableMap<AbilityType, SavingThrow>? by savingThrowsProperty

    val skillsProperty = SimpleMapProperty<SkillType, Skill>(generateDefaults { Skill(this, it) })
    var skills: ObservableMap<SkillType, Skill>? by skillsProperty

    val alignmentProperty = SimpleObjectProperty<Alignment>()
    val alignment: Alignment? by alignmentProperty

    val personalityTraitsProperty = SimpleStringProperty()
    var personalityTraits: String? by personalityTraitsProperty

    val idealsProperty = SimpleStringProperty()
    var ideals: String? by idealsProperty

    val bondsProperty = SimpleStringProperty()
    var bonds: String? by bondsProperty

    val flawsProperty = SimpleStringProperty()
    var flaws: String? by flawsProperty

    val characterNameProperty = SimpleStringProperty()
    var characterName: String? by characterNameProperty

    val playerNameProperty = SimpleStringProperty()
    var playerName: String? by playerNameProperty

    val expProperty = SimpleIntegerProperty(0)
    var exp: Int by expProperty

    val levelProperty = expProperty.integerBinding { expToLevel(it as Int) }
    val level: Int by levelProperty

    val proficiencyBonusProperty = levelProperty.integerBinding { 2 + (it as Int - 1) / 4 }
    val proficiencyBonus: Int by proficiencyBonusProperty


    companion object {
        private fun <T, S> generateDefaults(enumClass: KClass<T>, initScore: (T) -> S): ObservableMap<T, S>
                where T : Enum<T>, T : ScoreType, S : Score {
            var map = emptyMap<T, S>()
            for (type in enumClass.java.enumConstants) {
                map += type to initScore(type)
            }
            return map.observable()
        }

        /**
         * Returns a suitable list of default values for the [savingThrows], [skills], or [abilities].
         *
         * @param initScore A function that returns a new [S] given a [T], used to construct the map
         * @param T The type of score
         * @param S The score itself
         */
        private inline fun <reified T, S> generateDefaults(noinline initScore: (T) -> S): ObservableMap<T, S>
                where T : Enum<T>, T : ScoreType, S : Score {
            return generateDefaults(T::class, initScore)
        }
    }
}