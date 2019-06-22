package chapter8

import org.junit.Test

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

class TemplateMethodTest {
    @Test
    fun templateMethodTest() {
        val tea = Tea()
        val coffee = Coffee()
        println("making tea...")
        tea.prepareRecipe()
        println("\nmaking coffee...")
        coffee.prepareRecipe()
    }
}
