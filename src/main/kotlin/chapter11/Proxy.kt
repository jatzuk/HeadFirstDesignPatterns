package chapter11

import chapter10.GumballMachine
import chapter10.State
import java.rmi.Remote
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 25.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class GumballMonitor(private val gumballMachine: GumballMachine) {
    fun report() {
        try {
            with(gumballMachine) {
                println("Gumball Machine: $location")
                println("Current inventory: $count gumballs")
                println("Current state: ${state::class.java.simpleName}")
            }
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }
}

interface MyRemote : Remote {
    @Throws(RemoteException::class)
    fun sayHello(): String
}

class MyRemoteImpl @Throws(RemoteException::class) constructor() : UnicastRemoteObject(), MyRemote {
    override fun sayHello() = "Server says, 'Hey'"

    companion object {
        private const val SERIAL_VERSION_UID = 1L
    }
}

interface GumballMachineRemote : Remote {
    var count: Int

    val location: String

    var state: State
}
