package org.hedbor.evan.dndgen.ui

import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.ui.builder.CharacterBuilderWizard
import tornadofx.*

class CharacterView : View("D&D Character Generator") {
    private val characterSheet = CharacterSheetModel()

    override val root = vbox {
        menubar {
            menu("File") {
                item("New", "Shortcut+N") {
                    action {
                        find<CharacterBuilderWizard>().openModal()
                    }
                }
                item("Open", "Shortcut+O")
                item("Save", "Shortcut+S")
                item("Save As", "Shortcut+Shift+S")
                separator()
                item("Exit", "Shortcut+Q")
            }
            menu("Edit") {
                item("Cut", "Shortcut+X")
                item("Copy", "Shortcut+C")
                item("Paste", "Shortcut+V")
            }
        }
        form {
            hbox {
                fieldset {
                    for (abilityType in AbilityType.values()) {
                        field (abilityType.toString()) {
                            label(characterSheet.abilities.objectBinding { abilities ->
                                abilities?.get(abilityType)?.toString() ?: "N/A"
                            })
                        }
                    }
                }
                spacer { paddingHorizontal = 30 }
                fieldset {
                    field("Proficiency Bonus") {
                        label(characterSheet.proficiencyBonus)
                    }
                }
            }
        }
    }
}