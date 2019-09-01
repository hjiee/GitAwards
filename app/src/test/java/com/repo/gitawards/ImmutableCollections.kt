package com.repo.gitawards

import org.intellij.lang.annotations.Flow
import org.junit.Test
import kotlin.system.measureTimeMillis

class ImmutableCollections {
    @Test
    fun main() {

        val iList = listOf<Int>(1, 2, 3, 4, 5)
        val mList = mutableListOf<Int>(1, 2, 3, 4, 5)
    }
}