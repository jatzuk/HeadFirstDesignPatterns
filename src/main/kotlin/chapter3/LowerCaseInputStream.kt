package chapter3

import java.io.FilterInputStream
import java.io.InputStream

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

class LowerCaseInputStream(inputStream: InputStream) : FilterInputStream(inputStream) {
    override fun read(): Int {
        val c = super.`in`.read()
        return if (c == -1) c else (c.toChar()).toLowerCase().toInt()
    }

    override fun read(b: ByteArray?, off: Int, len: Int): Int {
        val result = super.`in`.read(b, off, len)
        for (i in off until off + result) b?.set(i, (b[i].toChar()).toLowerCase().toByte())
        return result
    }
}
