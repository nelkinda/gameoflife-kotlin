package com.nelkinda.training.gameoflife

import java.math.BigInteger

private val neighborSet = setOf(
        //@formatter:off
        P(-1,  1), P( 0,  1), P( 1,  1),
        P(-1,  0),            P( 1,  0),
        P(-1, -1), P( 0, -1), P( 1, -1)
        //@formatter:on
)

internal fun P(x: Int, y: Int) = Point(x, y)

internal data class Point constructor(private val x: Coordinate<X>, private val y: Coordinate<Y>) {
    constructor(x: Int, y: Int) : this(Coordinate(x), Coordinate(y))
    operator fun plus(p: Point) = Point(x + p.x, y + p.y)
    fun neighbors() = neighborSet.map { this + it }.toSet()
    inline fun neighbors(predicate: (Point) -> Boolean) = neighbors().filter(predicate).toSet()
    override fun toString() = "P($x, $y)"

    interface X : Coordinate.Dimension
    interface Y : Coordinate.Dimension
}

internal inline class Coordinate<T : Coordinate.Dimension>(private val value: BigInteger) {
    constructor(value: Int) : this(BigInteger.valueOf(value.toLong()))

    operator fun plus(other: Coordinate<T>) = Coordinate<T>(value.add(other.value))
    override fun toString() = value.toString()

    internal interface Dimension
}
