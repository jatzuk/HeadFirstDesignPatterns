package chapter4

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

abstract class AbstractFactoryPizza {
    val name: String = this::class.java.simpleName
    lateinit var dough: Dough
    lateinit var sauce: Sauce
    lateinit var veggies: Array<Veggies>
    lateinit var cheese: Cheese
    lateinit var pepperoni: Pepperoni
    lateinit var clams: Clams

    abstract fun prepare()

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

abstract class AbstractFactoryPizzaStore {
    fun orderPizza(type: PizzaType) = createPizza(type).apply {
        prepare()
        bake()
        cut()
        box()
    }

    protected abstract fun createPizza(type: PizzaType): AbstractFactoryPizza
}

class AbstractFactoryNYPizzaStore : AbstractFactoryPizzaStore() {
    private val ingredientFactory = NYPizzaIngredientFactory()

    override fun createPizza(type: PizzaType) = when (type) {
        PizzaType.CHEESE -> AbstractFactoryCheesePizza(ingredientFactory)
        PizzaType.VEGGIE -> AbstractFactoryVeggiePizza(ingredientFactory)
        PizzaType.CLAM -> AbstractFactoryClamPizza(ingredientFactory)
        PizzaType.PEPPERONI -> AbstractFactoryPepperoniPizza(ingredientFactory)
    }
}

class AbstractFactoryChicagoPizzaStore : AbstractFactoryPizzaStore() {
    private val ingredientFactory = ChicagoPizzaIngredientFactory()

    override fun createPizza(type: PizzaType) = when (type) {
        PizzaType.CHEESE -> AbstractFactoryCheesePizza(ingredientFactory)
        PizzaType.VEGGIE -> AbstractFactoryVeggiePizza(ingredientFactory)
        PizzaType.CLAM -> AbstractFactoryClamPizza(ingredientFactory)
        PizzaType.PEPPERONI -> AbstractFactoryPepperoniPizza(ingredientFactory)
    }
}

class AbstractFactoryCheesePizza(private val ingredientFactory: PizzaIngredientFactory) :
    AbstractFactoryPizza() {

    override fun prepare() {
        println("Preparing $name")
        with(ingredientFactory) {
            dough = createDough()
            sauce = createSauce()
            veggies = createVeggies()
            cheese = createCheese()
            pepperoni = createPepperoni()
            clams = createClams()
        }
    }
}

class AbstractFactoryVeggiePizza(private val ingredientFactory: PizzaIngredientFactory) :
    AbstractFactoryPizza() {

    override fun prepare() {
        println("Preparing $name")
        with(ingredientFactory) {
            dough = createDough()
            sauce = createSauce()
            veggies = createVeggies()
            cheese = createCheese()
            pepperoni = createPepperoni()
            clams = createClams()
        }
    }
}

class AbstractFactoryPepperoniPizza(private val ingredientFactory: PizzaIngredientFactory) :
    AbstractFactoryPizza() {
    override fun prepare() {
        println("Preparing $name")
        with(ingredientFactory) {
            dough = createDough()
            sauce = createSauce()
            veggies = createVeggies()
            cheese = createCheese()
            pepperoni = createPepperoni()
            clams = createClams()
        }
    }
}

class AbstractFactoryClamPizza(private val ingredientFactory: PizzaIngredientFactory) :
    AbstractFactoryPizza() {
    override fun prepare() {
        println("Preparing $name")
        with(ingredientFactory) {
            dough = createDough()
            sauce = createSauce()
            veggies = createVeggies()
            cheese = createCheese()
            pepperoni = createPepperoni()
            clams = createClams()
        }
    }
}


interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    fun createVeggies(): Array<Veggies>
    fun createPepperoni(): Pepperoni
    fun createClams(): Clams
}

open class Dough
open class Sauce
open class Cheese
open class Veggies
open class Pepperoni
open class Clams

sealed class NYTopping {
    class ThinCrustDough : Dough()
    class MarinaraSauce : Sauce()
    class ReggianoCheese : Cheese()
    class Garlic : Veggies()
    class Onion : Veggies()
    class Mushroom : Veggies()
    class RedPepper : Veggies()
    class SlicedPepperoni : Pepperoni()
    class FreshClams : Clams()
}

class NYPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough() = NYTopping.ThinCrustDough()

    override fun createSauce() = NYTopping.MarinaraSauce()

    override fun createCheese() = NYTopping.ReggianoCheese()

    override fun createVeggies() = arrayOf(
        NYTopping.Garlic(),
        NYTopping.Onion(),
        NYTopping.Mushroom(),
        NYTopping.RedPepper()
    )

    override fun createPepperoni() = NYTopping.SlicedPepperoni()

    override fun createClams() = NYTopping.FreshClams()
}

sealed class ChicagoTopping {
    class ThickCrustDough : Dough()
    class PlumTomatoSauce : Sauce()
    class MozzarellaCheese : Cheese()
    class Spinach : Veggies()
    class Eggplant : Veggies()
    class BlackOlives : Veggies()
    class SlicedPepperoni : Pepperoni()
    class FrozenClams : Clams()
}

class ChicagoPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough() = ChicagoTopping.ThickCrustDough()

    override fun createSauce() = ChicagoTopping.PlumTomatoSauce()

    override fun createCheese() = ChicagoTopping.MozzarellaCheese()

    override fun createVeggies() = arrayOf(
        ChicagoTopping.Spinach(),
        ChicagoTopping.Eggplant(),
        ChicagoTopping.BlackOlives()
    )

    override fun createPepperoni() = ChicagoTopping.SlicedPepperoni()

    override fun createClams() = ChicagoTopping.FrozenClams()
}
