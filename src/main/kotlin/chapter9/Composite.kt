package chapter9

import java.util.*
import kotlin.collections.ArrayList

/*
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 23.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

abstract class MenuComponent {
    @Throws(UnsupportedOperationException::class)
    open fun print() {
        throw UnsupportedOperationException()
    }

    abstract fun createIterator(): Iterator<MenuComponent?>
}

open class Menu(val name: String, val description: String) : MenuComponent() {
    val menuComponents = ArrayList<MenuComponent>()

    override fun print() {
        print("\n$name")
        println(", $description")
        println("----------")

        with(menuComponents.iterator()) {
            while (hasNext()) {
                next().print()
            }
        }
    }

    override fun createIterator(): Iterator<MenuComponent?> {
        return CompositeIterator(menuComponents.iterator())
    }
}

class CompositeIterator(iterator: Iterator<MenuComponent>) : Iterator<MenuComponent?> {
    private val stack = Stack<Iterator<MenuComponent?>>()

    init {
        stack.push(iterator)
    }

    override fun hasNext(): Boolean {
        return if (stack.isEmpty()) false
        else {
            val iterator = stack.peek()
            if (!iterator.hasNext()) {
                stack.peek()
                hasNext()
            } else true
        }
    }

    override fun next(): MenuComponent? {
        return if (hasNext()) {
            val iterator = stack.peek()
            val component = iterator.next()
            stack.push(component?.createIterator())
            component
        } else null
    }
}

class NullIterator : MutableIterator<MenuComponent?> {
    override fun hasNext() = false

    override fun next(): Nothing? = null

    @Throws(UnsupportedOperationException::class)
    override fun remove() {
        throw UnsupportedOperationException()
    }
}
