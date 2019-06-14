package chapter3

import org.junit.Test
import java.io.BufferedInputStream
import java.io.FileInputStream

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

class LowerCaseInputStreamTest {
    @Test
    fun lowerCaseInputStreamTest() {
        LowerCaseInputStream(BufferedInputStream(FileInputStream("src\\test\\resources\\chapter3\\test.txt"))).use {
            var c = it.read()
            while (c > -1) {
                print(c.toChar())
                c = it.read()
            }
        }
    }
}
