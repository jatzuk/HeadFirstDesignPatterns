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
    lateinit var name: String
    lateinit var dough: String
    lateinit var sauce: String
    val toppings = ArrayList<String>()

    fun prepare() {
        println("Preparing $name")
        println("Tossing dough...")
        println("Adding sauce...")
        println("Adding toppings:")
        toppings.forEach { println("\t$it") }
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

class NYStyleCheesePizza : Pizza() {
    init {
        name = "NY Style Sauce and Cheese Pizza"
        dough = "Thin Crust Dough"
        sauce = "Marinara Sauce"
        toppings.add("Grated Reggiano Cheese")
    }
}

class NYStyleVeggiePizza : Pizza() {
    init {
        name = "NY Style Sauce and Cheese Pizza"
        dough = "Thin Crust Dough"
        sauce = "Marinara Sauce"
        toppings.add("Grated Reggiano Cheese")
    }
}

class ChicagoStyleCheesePizza : Pizza() {
    init {
        name = "Chicago Style Deep Dish Cheese Pizza"
        dough = "Extra thick Crust Dough"
        sauce = "Plum Tomato Sauce"
        toppings.add("Shredded Mozzarella Cheese")
    }

    override fun cut() {
        println("Cutting the pizza into square slices")
    }
}

enum class PizzaType(name: String) {
    CHEESE("cheese"), VEGGIE("veggie"), CLAM("clam"), PEPPERONI("pepperoni")
}
