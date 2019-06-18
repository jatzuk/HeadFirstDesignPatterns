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
            command = LightOnCommand(Light())
            buttonWasPressed()
        }
    }

    @Test
    fun garageLightTest() {
        with(remote) {
            command = GarageDoorUpCommand(GarageDoor())
            buttonWasPressed()
        }
    }
}
