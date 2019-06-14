package chapter3

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

abstract class Beverage {
    var description = "Unknown Beverage"

    abstract var cost: Double
}

abstract class CondimentDecorator : Beverage()

class Espresso : Beverage() {
    override var cost = 1.99

    init {
        description = this::class.java.simpleName
    }
}

class DarkRoast : Beverage() {
    override var cost = 0.99

    init {
        description = this::class.java.simpleName
    }
}

class HouseBlend : Beverage() {
    override var cost = 0.89

    init {
        description = this::class.java.simpleName
    }
}

class Mocha(beverage: Beverage) : CondimentDecorator() {
    override var cost = 0.20 + beverage.cost

    init {
        description = "${beverage.description}, ${this::class.java.simpleName}"
    }
}

class Soy(beverage: Beverage) : CondimentDecorator() {
    override var cost = 0.15 + beverage.cost

    init {
        description = "${beverage.description}, ${this::class.java.simpleName}"
    }
}

class Whip(beverage: Beverage) : CondimentDecorator() {
    override var cost = 0.10 + beverage.cost

    init {
        description = "${beverage.description}, ${this::class.java.simpleName}"
    }
}

