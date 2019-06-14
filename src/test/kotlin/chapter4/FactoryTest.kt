package chapter4

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

class FactoryTest {
    @Test
    fun factoryTest() {
        val nyStore = NYPizzaStore()
        val chicagoStore = ChicagoPizzaStore()

        var pizza = nyStore.orderPizza(PizzaType.CHEESE)
        println("Ethan ordered a ${pizza.name}\n")
        pizza = chicagoStore.orderPizza(PizzaType.CHEESE)
        println("Joel ordered a ${pizza.name}\n")
    }
}
