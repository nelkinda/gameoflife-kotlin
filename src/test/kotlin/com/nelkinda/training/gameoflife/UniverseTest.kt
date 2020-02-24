package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class UniverseTest {
    @Test
    fun equality() {
        val u1 = Universe(StandardRules(setOf(), setOf()), setOf())
        val u2 = Universe(StandardRules(setOf(), setOf()), setOf())
        assertEquals(u1, u2)
        assertEquals(u1.hashCode(), u2.hashCode())
    }

    @Test
    fun inEquality() {
        val u1 = Universe(StandardRules(setOf(), setOf(1)), setOf())
        val u2 = Universe(StandardRules(setOf(1), setOf()), setOf())
        assertNotEquals(u1, u2)
        assertNotEquals(u1.hashCode(), u2.hashCode())
    }

    @Test
    fun testToString() = assertEquals("Universe{R 23/3\n[P(0, 1)]}", Universe(life = setOf(P(0, 1))).toString())
}