package com.nelkinda.training.gameoflife

internal fun `parse simplified Life 1_05`(life1_05: String): Universe {
    val cells = HashSet<Cell>()
    var line = 0
    var column = 0
    for (c in life1_05) {
        when (c) {
            '\n' -> {
                line++
                column = 0
            }
            '*' -> {
                cells.add(P(column, line))
                column++
            }
            '.' -> column++
            else -> throw IllegalArgumentException("Unexpected character '$c' at line $line, column $column")
        }
    }
    return Universe(life = cells.toSet())
}
