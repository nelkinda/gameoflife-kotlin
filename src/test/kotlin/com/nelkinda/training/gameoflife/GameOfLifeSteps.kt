package com.nelkinda.training.gameoflife

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import kotlin.test.assertEquals

class GameOfLifeSteps {
    private lateinit var universe: Universe

    @Given("the following universe:")
    fun defineUniverse(spec: String) {
        universe = `parse simplified Life 1_05 format`(spec)
    }

    @Then("the next generation MUST be:")
    fun assertNextGenerationEquals(spec: String) {
        ++universe
        assertEquals(`parse simplified Life 1_05 format`(spec), universe)
    }
}