package com.nelkinda.training.gameoflife

import com.nelkinda.training.gameoflife.life2d.Point2D

internal typealias P = Point2D

@Suppress("FunctionParameterNaming")
internal fun `parse simplified Life 1_05`(life1_05: String): Universe<P> {
    val cells = HashSet<P>()
    var line = 1
    var column = 1
    val syntax = mapOf(
        '\n' to { line++; column = 0 },
        '*' to { cells.add(P(column - 1, line - 1)) },
        '.' to { },
    ).withDefault { c -> throw IllegalArgumentException("Unexpected character '$c' at line $line, column $column") }
    life1_05.forEach {
        syntax.getValue(it).invoke()
        column++
    }
    return Universe(life = cells.toSet())
}
