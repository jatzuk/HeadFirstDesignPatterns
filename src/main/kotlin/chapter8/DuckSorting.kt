package chapter8

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

class Duck(private val name: String, private val weight: Int) : Comparable<Duck> {
    override fun toString() = "$name | $weight"

    override fun compareTo(other: Duck) = when {
        weight < other.weight -> -1
        weight == other.weight -> 0
        else -> 1
    }
}
