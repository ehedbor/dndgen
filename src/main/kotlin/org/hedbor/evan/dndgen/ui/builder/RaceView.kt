package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.type.Race
import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.*


/**
 * Inputs the character's [Race].
 */
class RaceView : View("Choose a Race") {
    val model: CharacterSheetModel by inject()

    override val root = form {
        fieldset(title) {
            label("Placeholder. Describe races in general. Find a way to view race details.")
            field("Race") {
                combobox(model.race) {
                    items = listOf(Race.Human).observable()
                    required()
                }
            }
        }
    }
}