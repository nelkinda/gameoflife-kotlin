package com.nelkinda.training.gameoflife.life3d

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private typealias P = Point3D

internal class Point3DTest {
    @Test
    fun testToString() = assertEquals("P(0, 1, 2)", P(0, 1, 2).toString())

    @Test
    fun plus() = assertEquals(P(3, 30, 300), P(2, 20, 200) + P(1, 10, 100))

    @SuppressWarnings("MaxLineLength")
    @Test
    fun neighbors() = assertEquals(
        setOf(
            P(4, 49, 501), P(4, 50, 501), P(4, 51, 501), P(5, 49, 501), P(5, 50, 501), P(5, 51, 501), P(6, 49, 501), P(6, 50, 501), P(6, 51, 501),
            P(4, 49, 500), P(4, 50, 500), P(4, 51, 500), P(5, 49, 500),                P(5, 51, 500), P(6, 49, 500), P(6, 50, 500), P(6, 51, 500), // ktlint-disable no-multi-spaces
            P(4, 49, 499), P(4, 50, 499), P(4, 51, 499), P(5, 49, 499), P(5, 50, 499), P(5, 51, 499), P(6, 49, 499), P(6, 50, 499), P(6, 51, 499),
        ),
        P(5, 50, 500).neighbors().toSet(),
    )

    @Test
    fun neighborsFiltered() = assertEquals(
        setOf(P(4, 49, 499)),
        P(5, 50, 500).neighbors { it == P(4, 49, 499) }.toSet(),
    )
}
