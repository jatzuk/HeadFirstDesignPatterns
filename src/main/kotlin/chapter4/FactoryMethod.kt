package chapter4

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

abstract class Pizza {
    val name: String = this::class.java.simpleName

    fun prepare() {
        println("Preparing $name")
        println("Tossing dough...")
        println("Adding sauce...")
        println("Adding toppings:")
    }

    open fun bake() {
        println("Bake for 25 minutes at 350")
    }

    open fun cut() {
        println("Cutting the pizza into diagonal slices")
    }

    open fun box() {
        println("Place pizza in official PizzaStore box")
    }
}

abstract class PizzaStore {
    fun orderPizza(type: PizzaType) = createPizza(type).apply {
        prepare()
        bake()
        cut()
        box()
    }

    protected abstract fun createPizza(type: PizzaType): Pizza
}

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: PizzaType) = when (type) {
        PizzaType.CHEESE -> NYStyleCheesePizza()
        PizzaType.VEGGIE -> NYStyleVeggiePizza()
        PizzaType.CLAM -> NYStyleClamPizza()
        PizzaType.PEPPERONI -> NYStylePepperoniPizza()
    }
}

class NYStyleCheesePizza : Pizza()
class NYStyleVeggiePizza : Pizza()
class NYStyleClamPizza : Pizza()
class NYStylePepperoniPizza : Pizza()

class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(type: PizzaType) = when (type) {
        PizzaType.CHEESE -> ChicagoStyleCheesePizza()
        PizzaType.VEGGIE -> ChicagoStyleVeggiePizza()
        PizzaType.CLAM -> ChicagoStyleClamPizza()
        PizzaType.PEPPERONI -> ChicagoStylePepperoniPizza()
    }
}

class ChicagoStyleCheesePizza : Pizza()
class ChicagoStyleVeggiePizza : Pizza()
class ChicagoStyleClamPizza : Pizza()
class ChicagoStylePepperoniPizza : Pizza()

enum class PizzaType { CHEESE, VEGGIE, CLAM, PEPPERONI }
