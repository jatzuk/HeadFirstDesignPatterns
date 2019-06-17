package chapter4

import org.junit.Test

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 17.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class FactoriesTest {
    @Test
    fun factoryMethodTest() {
        var pizza = NYPizzaStore().orderPizza(PizzaType.CHEESE)
        println("Ethan ordered a ${pizza.name}\n")
        pizza = ChicagoPizzaStore().orderPizza(PizzaType.CHEESE)
        println("Joel ordered a ${pizza.name}\n")
    }

    @Test
    fun abstractFactoryTest() {
        var pizza = AbstractFactoryNYPizzaStore().orderPizza(PizzaType.CHEESE)
        println("Ethan ordered a ${pizza.name}\n")
        pizza = AbstractFactoryChicagoPizzaStore().orderPizza(PizzaType.CHEESE)
        println("Joel ordered a ${pizza.name}\n")
    }
}
