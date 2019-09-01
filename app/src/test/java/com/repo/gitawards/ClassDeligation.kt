package com.repo.gitawards

import org.junit.Test

class ClassDeligation {
    @Test
    fun main() {
        val coffeeMaker = CoffeeMaker(MyDripCoffeeModule())
        coffeeMaker.brew()
    }


    interface Heater {
        fun on()
        fun off()
        fun isHot() : Boolean
    }

    class ElectricHeater(var heating: Boolean = false) : Heater {
        override fun on() {
            println("~ ~ ~ heating ~ ~ ~")
            heating = true
        }

        override fun off() {
            heating = false
        }

        override fun isHot() : Boolean {
            return heating
        }
    }

    interface Pump {
        fun pump()
    }

    class Thermosiphon(heater: Heater) : Pump, Heater by heater {
        override fun pump() {
            if (isHot()) {
                println("=> => pumping => =>");
            }
        }
    }

    interface CoffeeModule {
        fun getThermosiphon() : Thermosiphon
    }

    class MyDripCoffeeModule : CoffeeModule {
        companion object {
            val electricHeater: ElectricHeater by lazy {
                ElectricHeater()
            }
        }

        private val _thermosiphon : Thermosiphon by lazy {
            Thermosiphon(electricHeater)
        }

        override fun getThermosiphon() : Thermosiphon = _thermosiphon
    }

    class CoffeeMaker(val coffeeModule: CoffeeModule) {
        fun brew() {
            coffeeModule.getThermosiphon().run {
                on()
                pump()
                println(" [_]P coffee! [_]P ")
                off()
            }
        }
    }


}
