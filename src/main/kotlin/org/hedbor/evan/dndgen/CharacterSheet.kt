package org.hedbor.evan.dndgen

import javafx.beans.property.*
import javafx.collections.FXCollections
import javafx.collections.ObservableMap
import org.hedbor.evan.dndgen.score.Ability
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.Race
import org.hedbor.evan.dndgen.type.SkillType
import org.hedbor.evan.dndgen.util.expToLevel
import tornadofx.*


/**
 * Eventual replacement for [org.hedbor.evan.dndgen.CharacterSheet]
 */
@Suppress("MemberVisibilityCanBePrivate")
class CharacterSheet {
    val raceProperty = SimpleObjectProperty<Race?>()
    var race: Race? by raceProperty

    val abilitiesProperty = SimpleMapProperty<AbilityType, Ability>()
    var abilities: ObservableMap<AbilityType, Ability>? by abilitiesProperty

    val savingThrowsProperty = SimpleMapProperty<AbilityType, SavingThrow>()
    var savingThrows: ObservableMap<AbilityType, SavingThrow>? by savingThrowsProperty

    val skillsProperty = SimpleMapProperty<SkillType,Skill>()
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
}