package chapter7

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

class Chapter7Tests {
    @Test
    fun adapterTest() {
        val duck = MallardDuck()
        val turkey = WildTurkey()
        val turkeyAdapter = TurkeyAdapter(turkey)

        println("The Turkey says...")
        turkey.gobble()
        turkey.fly()

        println("\nThe Duck says...")
        duck.quack()
        duck.fly()

        println("\nThe TurkeyAdapter says...")
        turkeyAdapter.quack()
        turkeyAdapter.fly()
    }


    fun facadeTest() {
//        not too complicated
//        omitted because of its simplicity
    }
}
