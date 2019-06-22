package chapter8

import org.junit.Test
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

class DuckSortingTest {
    @Test
    fun duckSortingTest() {
        val ducks = arrayOf(
            Duck("Daffy", 8),
            Duck("Dewey", 2),
            Duck("Howard", 7),
            Duck("Louie", 2),
            Duck("Donald", 10),
            Duck("Hue", 2)
        )
        println("before sorting:")
        ducks.forEach { println(it) }

        Arrays.sort(ducks)
        println("\nafter sorting:")
        ducks.forEach { println(it) }
    }
}
