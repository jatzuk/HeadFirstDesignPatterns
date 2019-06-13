package chapter1

import org.junit.Test


/*
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 10.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class SimUDuckTest {
    @Test
    fun simUDuckTest() {
        with(MallardDuck()) {
            performQuack()
            performFly()
        }

        ModelDuck().apply {
            performFly()
            flyBehavior = FlyRocketPowered()
            performFly()
        }
    }
}
