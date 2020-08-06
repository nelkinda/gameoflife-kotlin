package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

internal class RulesTest {
    private fun assertSurvival(rules: Rules, liveNeighbors: Set<Int>) = assertAll(
            (0..8).map {
                { assertEquals(it in liveNeighbors, rules.survives(it)) }
            }
    )

    private fun assertBirth(rules: Rules, liveNeighbors: Set<Int>) = assertAll(
            (0..8).map {
                { assertEquals(it in liveNeighbors, rules.born(it)) }
            }
    )

    @Test
    fun testConwayRules() = assertAll(
            { assertEquals("R 23/3", ConwayRules.toString()) },
            { assertSurvival(ConwayRules, setOf(2, 3)) },
            { assertBirth(ConwayRules, setOf(3)) }
    )

    @Test
    fun testHighlifeRules() = assertAll(
            { assertEquals("R 23/36", HighlifeRules.toString()) },
            { assertSurvival(HighlifeRules, setOf(2, 3)) },
            { assertBirth(HighlifeRules, setOf(3, 6)) }
    )
}
