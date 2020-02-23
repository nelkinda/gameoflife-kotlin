package com.nelkinda.training.gameoflife

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import kotlin.test.assertEquals

class GameOfLifeSteps {
    private lateinit var universe: Universe

    @Given("the following universe:")
    fun defineUniverse(spec: String) {
        universe = parse(spec)
    }

    @Then("the next generation MUST be:")
    fun assertNextGenerationEquals(spec: String) {
        universe = universe.next()
        assertEquals(parse(spec), universe)
    }
}