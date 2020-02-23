package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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
    fun equality() {
        val rules1 = StandardRules(setOf(), setOf())
        val rules2 = StandardRules(setOf(), setOf())
        assertEquals(rules1, rules2)
        assertEquals(rules1.hashCode(), rules2.hashCode())
    }

    @Test
    fun inEquality() {
        val rules1 = StandardRules(setOf(), setOf(1))
        val rules2 = StandardRules(setOf(1), setOf())
        assertNotEquals(rules1, rules2)
        assertNotEquals(rules1.hashCode(), rules2.hashCode())
    }
}