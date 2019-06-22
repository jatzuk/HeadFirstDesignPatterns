package chapter7

import java.util.*

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 22.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

interface Duck {
    fun quack()

    fun fly()
}

interface Turkey {
    fun gobble()

    fun fly()
}

class MallardDuck : Duck {
    override fun quack() {
        println("Quack")
    }

    override fun fly() {
        println("I'm flying")
    }
}

class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }

    override fun fly() {
        println("I'm flying a short distance")
    }
}

class TurkeyAdapter(private val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        repeat(5) { turkey.fly() }
    }
}

class IteratorToEnumeration(private val iterator: Iterator<*>) : Enumeration<Any> {

    override fun hasMoreElements() = iterator.hasNext()

    override fun nextElement() = iterator.next()
}
