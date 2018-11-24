package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.*


/**
 * Inputs the player name and character name.
 */
class FinishingTouchesView : View("Finishing Touches") {
    companion object {
        private const val COLUMN_COUNT = 15
    }

    val model: CharacterSheetModel by inject()

    override val root = form {
        fieldset(title) {
            label("Placeholder text. Short description.")
            field("Character Name") {
                textfield(model.characterName) {
                    prefColumnCount = COLUMN_COUNT
                }
            }
            field("Player Name") {
                textfield(model.playerName) {
                    prefColumnCount = COLUMN_COUNT
                }
            }
        }
    }
}