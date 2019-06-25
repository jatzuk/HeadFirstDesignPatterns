package chapter10

import chapter11.GumballMachineRemote
import java.io.Serializable
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject
import kotlin.random.Random

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

class GumballMachine @Throws(RemoteException::class) constructor(
    override var count: Int,
    override val location: String = "undefined location"
) : UnicastRemoteObject(), GumballMachineRemote {
    val soldOutState = SoldOutState()
    val noQuarterState = NoQuarterState(this)
    val hasQuarterState = HasQuarterState(this)
    val soldState = SoldState(this)
    val winnerState = WinnerState(this)
    override var state = if (count > 0) noQuarterState else soldOutState

    fun insertQuarter() {
        state.insertQuarter()
    }

    fun ejectQuarter() {
        state.ejectQuarter()
    }

    fun turnCrank() {
        state.turnCrank()
        state.dispense()
    }

    fun releaseGumball() {
        println("A gumball comes rolling out the slot")
        if (count > 0) count--
    }

    fun refill(count: Int) {
        this.count = count
        state = noQuarterState
    }

    override fun toString() = "Gumball machine has $count gumballs"
}

interface State : Serializable {
    fun insertQuarter()

    fun ejectQuarter()

    fun turnCrank()

    fun dispense()
}

class SoldState(private val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("Please wait we're already giving you a gumball")
    }

    override fun ejectQuarter() {
        println("Sorry, you already turned the crank")
    }

    override fun turnCrank() {
        println("Turning twice doesn't get you another gumball !")
    }

    override fun dispense() {
        with(gumballMachine) {
            if (state == gumballMachine.soldState) {
                releaseGumball()
                state = if (count > 0) noQuarterState
                else {
                    println("Oops, out of gumballs!")
                    soldOutState
                }
            }
        }
    }
}

class SoldOutState : State {
    override fun insertQuarter() {
        println("You can not insert a quarter, the machine is sold out")
    }

    override fun ejectQuarter() {
        println("You can not eject, you haven't inserted a quarter yet")
    }

    override fun turnCrank() {
        println("You turned, but there are no gumballs")
    }

    override fun dispense() {
        println("No gumball dispensed")
    }
}

class NoQuarterState(@Transient private val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("You inserted a quarter")
        gumballMachine.state = gumballMachine.hasQuarterState
    }

    override fun ejectQuarter() {
        println("You haven't inserted a quarter")
    }

    override fun turnCrank() {
        println("You turned but there's no quarter")
    }

    override fun dispense() {
        println("You need to pay first")
    }
}

class HasQuarterState(@Transient private val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("You can not insert another quarter")
    }

    override fun ejectQuarter() {
        gumballMachine.state = gumballMachine.noQuarterState
        println("Quarter returned")
    }

    override fun turnCrank() {
        println("You turned...")
        with(gumballMachine) {
            state = if (Random(System.currentTimeMillis()).nextInt(10) == 0 && count > 1) {
                winnerState
            } else gumballMachine.soldState
        }
    }

    override fun dispense() {
        println("No gumball dispensed")
    }
}

class WinnerState(@Transient private val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("Please wait we're already giving you a gumball")
    }

    override fun ejectQuarter() {
        println("Sorry, you already turned the crank")
    }

    override fun turnCrank() {
        println("Turning twice doesn't get you another gumball !")
    }

    override fun dispense() {
        with(gumballMachine) {
            releaseGumball()
            if (count == 0) state = soldOutState
            else {
                releaseGumball()
                println("YOU'RE A WINNER! YOU GOT TWO GUMBALLS FOR YOUR QUARTER")
                state = if (count > 0) noQuarterState
                else {
                    println("Oops, out of gumballs!")
                    soldOutState
                }
            }
        }
    }
}
