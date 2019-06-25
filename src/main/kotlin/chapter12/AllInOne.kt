package chapter12

interface Quackable : QuackObservable {
    fun quack()
}

class MallardDuck : Quackable {
    val observable = Observable(this)

    override fun quack() {
        println("Quack")
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObservers() {
        observable.notifyObservers()
    }
}

class RedHeadDuck : Quackable {
    val observable = Observable(this)

    override fun quack() {
        println("Quack")
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObservers() {
        observable.notifyObservers()
    }
}

class DuckCall : Quackable {
    val observable = Observable(this)

    override fun quack() {
        println("Kwak")
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObservers() {
        observable.notifyObservers()
    }
}

class RubberDuck : Quackable {
    val observable = Observable(this)

    override fun quack() {
        println("Squeak")
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObservers() {
        observable.notifyObservers()
    }
}

fun simulate(duck: Quackable) {
    duck.quack()
}

class Goose {
    fun honk() {
        println("Honk")
    }
}

class GooseAdapter(private val goose: Goose) : Quackable {
    val observable = Observable(this)

    override fun quack() {
        goose.honk()
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObservers() {
        observable.notifyObservers()
    }
}

class QuackCounter(private val ducks: Quackable) : Quackable {
    val observable = Observable(this)

    companion object {
        var numberOfQuacks = 0
    }

    override fun quack() {
        numberOfQuacks++
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObservers() {
        observable.notifyObservers()
    }
}

abstract class AbstractDuckFactory {
    abstract fun creteMallardDuck(): Quackable
    abstract fun createRedHeadDuck(): Quackable
    abstract fun createDuckCall(): Quackable
    abstract fun createRubberDuck(): Quackable
}

class DuckFactory : AbstractDuckFactory() {
    override fun creteMallardDuck(): Quackable {
        return MallardDuck()
    }

    override fun createRedHeadDuck(): Quackable {
        return RedHeadDuck()
    }

    override fun createDuckCall(): Quackable {
        return DuckCall()
    }

    override fun createRubberDuck(): Quackable {
        return RubberDuck()
    }
}

class CountingDuckFactory : AbstractDuckFactory() {
    override fun creteMallardDuck(): Quackable {
        return QuackCounter(MallardDuck())
    }

    override fun createRedHeadDuck(): Quackable {
        return QuackCounter(RedHeadDuck())
    }

    override fun createDuckCall(): Quackable {
        return QuackCounter(DuckCall())
    }

    override fun createRubberDuck(): Quackable {
        return QuackCounter(RubberDuck())
    }
}

fun simulate(duckFactory: AbstractDuckFactory) {
    with(duckFactory) {
        val mallardDuck = creteMallardDuck()
        val redHeadDuck = createRedHeadDuck()
        val duckCall = createDuckCall()
        val gooseDuck = GooseAdapter(Goose())


    }
}

class Flock : Quackable {
    override fun notifyObservers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerObserver(observer: Observer) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val quackers = ArrayList<Quackable>()

    fun add(quacker: Quackable) {
        quackers.add(quacker)
    }

    override fun quack() {
        val iterator = quackers.iterator()
        while (iterator.hasNext()) iterator.next().quack()
    }
}

interface QuackObservable {
    fun registerObserver(observer: Observer)
    fun notifyObservers()
}

class Observable(private val duck: QuackObservable) : QuackObservable {
    val observers = ArrayList<Observer>()

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun notifyObservers() {
        val iterator = observers.iterator()
        while (iterator.hasNext()) iterator.next().update(duck)
    }
}

interface Observer {
    fun update(duck: QuackObservable)
}

class Quackologist : Observer {
    override fun update(duck: QuackObservable) {
        println("Quackologist: $duck just quacked")
    }
}

fun main() {


}
