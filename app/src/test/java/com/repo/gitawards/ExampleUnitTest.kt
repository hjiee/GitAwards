package com.repo.gitawards

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        some()
    }

    fun some() {
        val str : String? = getString()

        val answer : Int

        run{
            answer = 42
        }



        if(!str.isNullOrEmpty()) {
            println(str.length)
        }
    }
    fun getString() : String? = null
}
