package com.nelkinda.training.gameoflife

internal fun parse(s: String): Universe {
    val cells = HashSet<Point>()
    var line = 0
    var column = 0
    for (c in s) {
        when (c) {
            '\n' -> {
                line++
                column = 0
            }
            'x' -> {
                cells.add(P(column, line))
                column++
            }
            '.' -> column++
            else -> throw IllegalArgumentException("Unexpected character '$c' at line $line, column $column")
        }
    }
    return Universe(cells.toSet())
}
