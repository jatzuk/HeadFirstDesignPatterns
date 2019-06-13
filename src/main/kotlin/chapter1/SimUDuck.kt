package chapter1

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

interface FlyBehavior {
    fun fly()
}

interface QuackBehavior {
    fun quack()
}

abstract class Duck(var quackBehavior: QuackBehavior, var flyBehavior: FlyBehavior) {

    abstract fun display()

    fun performFly() {
        flyBehavior.fly()
    }

    fun performQuack() {
        quackBehavior.quack()
    }

    fun swim() {
        println("All ducks float, even decoys!")
    }
}

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying!")
    }
}

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly!")
    }
}

class Quack : QuackBehavior {
    override fun quack() {
        println("Quack")
    }
}

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence >>")
    }
}

class Squeak : QuackBehavior {
    override fun quack() {
        println("Squeak")
    }
}

class MallardDuck : Duck(Quack(), FlyWithWings()) {
    override fun display() {
        println("I'm a real Mallard duck")
    }
}

class ModelDuck : Duck(Quack(), FlyNoWay()) {
    override fun display() {
        println("I'am a model duck")
    }
}

class FlyRocketPowered : FlyBehavior {
    override fun fly() {
        println("I'm flying with a rocket!")
    }
}
