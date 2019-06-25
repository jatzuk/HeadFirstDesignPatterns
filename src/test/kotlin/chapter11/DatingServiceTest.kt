package chapter11

import org.junit.Test

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 25.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class DatingServiceTest {
    @Test
    fun datingServiceTest() {
        val joe = PersonBeanImpl()
        joe.name = "Joe"
        joe.gender = "male"
        val ownerProxy = getOwnerProxy(joe)
        ownerProxy.interests = "1, 2, 3"
        println(joe)

        try {
            ownerProxy.hotOrNotRating = 1
        } catch (e: Exception) {
            e.printStackTrace()
        }

        println("rating is: ${ownerProxy.hotOrNotRating}")

        val nonOwnerProxy = getNonOwnerProxy(joe)
        println(nonOwnerProxy.name)

        try {
            nonOwnerProxy.interests = "3, 4, 5"
        } catch (e: Exception) {
            e.printStackTrace()
        }

        nonOwnerProxy.hotOrNotRating = 5
        println(nonOwnerProxy.hotOrNotRating)
    }
}
