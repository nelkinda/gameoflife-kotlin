package com.nelkinda.training.gameoflife.life3d

import com.nelkinda.training.gameoflife.Point

private typealias P = Point3D

private val neighborsOfOrigin = (P(-1, -1, -1)..P(1, 1, 1)).filter { it != P(0, 0, 0) }

data class Point3D(private val x: Int, private val y: Int, private val z: Int) : Point<P> {
    override fun plus(p: P): P = P(x + p.x, y + p.y, z + p.z)
    override fun rangeTo(p: P): List<P> =
            (x..p.x).map { x -> (y..p.y).map { y -> (z..p.z).map { z -> P(x, y, z) } } }.flatten().flatten()
    override fun neighbors() = neighborsOfOrigin.map { this + it }
    override fun toString() = "P($x, $y, $z)"
}
