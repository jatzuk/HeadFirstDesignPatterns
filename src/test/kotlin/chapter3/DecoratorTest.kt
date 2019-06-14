package chapter3

import org.junit.Test

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 14.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class DecoratorTest {
    @Test
    fun decoratorTest() {
        with(Espresso()) { println("$description $$cost") }
        var beverage: Beverage = DarkRoast()
        beverage = Mocha(beverage)
        beverage = Mocha(beverage)
        beverage = Whip(beverage)
        println("${beverage.description} $${beverage.cost}")
    }
}
