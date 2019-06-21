package chapter6

import org.junit.Test

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 18.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class CommandTest {
    private val remote = SimpleRemoteControl()

    @Test
    fun lightTest() {
        with(remote) {
            command = Command { Light().on() }
            buttonWasPressed()
        }
    }

    @Test
    fun garageLightTest() {
        with(remote) {
            command = Command { GarageDoor().lightOn() }
            buttonWasPressed()
        }
    }

    @Test
    fun functionalTest() {
        val light = Light()
        val fan = CeilingFan()
        val garage = GarageDoor()
        with(RemoteControl()) {
            onCommands[0] = Command { light.on() }
            offCommands[0] = Command { light.off() }

            onCommands[1] = Command { fan.on() }
            offCommands[1] = Command { fan.off() }

            onCommands[2] = Command { garage.lightOn() }
            offCommands[2] = Command { garage.lightOff() }

            repeat(3) {
                onButtonWasPushed(it)
                offButtonWasPushed(it)
            }
        }
    }
}
