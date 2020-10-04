package com.nelkinda.training.gameoflife

interface Point<P : Point<P>> {
    operator fun plus(p: P): P
    operator fun rangeTo(p: P): List<P>
    fun neighbors(): List<P>
    @JvmDefault
    fun neighbors(predicate: (P) -> Boolean): List<P> = neighbors().filter(predicate)
}
