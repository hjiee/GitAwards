package com.repo.gitawards

import org.jetbrains.annotations.Contract
import org.junit.Test
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


class ContractTest {
    @ExperimentalContracts
    @Test
    fun main() {
        contractTest()
    }




    @ExperimentalContracts
    inline fun contractTest() : Int {
        val intContract : Int
        runTest {
            // captured values init is forbidden 에러
            intContract = 23
        }

        //variable must be initilized 에러
        return intContract
    }
}

@ExperimentalContracts
inline fun <R>runTest(block: () -> R) {
    contract{
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
}