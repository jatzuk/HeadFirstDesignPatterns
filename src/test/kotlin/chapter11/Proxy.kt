package chapter11

import chapter10.GumballMachine
import org.junit.Test
import java.rmi.Naming

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

class Proxy {
    private val gumballMachine = GumballMachine(5, "Seattle")
    private val gumballMonitor = GumballMonitor(gumballMachine)

    @Test
    fun proxyTest() {
        gumballMonitor.report()
    }

    @Test
    fun rmiTest() {
        try {
            val service = Naming.lookup("rmi://127.0.0.1/RemoteHello") as MyRemote
            val response = service.sayHello()
            println(response)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test
    fun rmiGumballTest() {
        try {
            val machine = GumballMachine(23, "some city")
            Naming.rebind("name", machine)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
