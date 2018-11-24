package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.*


/**
 * Determines the character's ability scores
 */
class AbilityScoresView : View("Determine Ability Scores") {
    val model: CharacterSheetModel by inject()

    override val root = form {
        fieldset(title) {
            label("Placeholder text. Describe ability scores and provide some randomly generated ones.")
            for (abilityType in AbilityType.values()) {
                // TODO: have the field change the ability scores
                field (abilityType.toString()) {
                    textfield {
                        prefColumnCount = 4
                    }
                }
            }
        }
    }
}