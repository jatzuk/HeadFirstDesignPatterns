package chapter10

import org.junit.Test

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 23.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class StateTest {
    private val machine = GumballMachine(5)

    @Test
    fun gumballBaseTest() {
        with(machine) {
            println(this)
            insertQuarter()
            turnCrank()
            println(this)
        }
    }

    @Test
    fun refundTest() {
        with(machine) {
            insertQuarter()
            ejectQuarter()
            turnCrank()
            println(this)
        }
    }

    @Test
    fun noCoinTest() {
        with(machine) {
            insertQuarter()
            turnCrank()
            insertQuarter()
            turnCrank()
            ejectQuarter()
            println(this)
        }
    }

    @Test
    fun twoQuartersTest() {
        with(machine) {
            insertQuarter()
            insertQuarter()
            repeat(5) {
                turnCrank()
                insertQuarter()
            }
            turnCrank()
            println(this)
        }
    }

    @Test
    fun v2Test() {
        with(machine) {
            println(machine)
            repeat(4) {
                insertQuarter()
                turnCrank()
            }
            println(this)
        }
    }

    @Test
    fun refillTest() {
        with(machine) {
            repeat(5) {
                insertQuarter()
                turnCrank()
            }
            println(this)

            refill(10)
            println(this)
            insertQuarter()
            turnCrank()
            println(this)
        }
    }
}
