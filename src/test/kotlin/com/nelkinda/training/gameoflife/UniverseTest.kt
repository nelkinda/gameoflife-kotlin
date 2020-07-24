package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class UniverseTest {
    @Test
    fun testToString() = assertEquals("Universe{R 23/3\n[P(0, 1)]}", Universe(life = setOf(P(0, 1))).toString())
}
