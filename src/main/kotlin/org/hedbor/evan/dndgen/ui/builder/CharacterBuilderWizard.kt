package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.Wizard


/**
 * Provides a step-by-step character creation process.
 */
class CharacterBuilderWizard : Wizard(
    title = "D&D Character Generator",
    heading = "Create a character for Dungeons & Dragons Fifth Edition."
) {
    val model: CharacterSheetModel by inject()

    init {
        add(IntroView::class)
        add(RaceView::class)
        add(ClassView::class)
        add(AbilityScoresView::class)
        add(DescriptionView::class)
        add(FinishingTouchesView::class)
    }
}