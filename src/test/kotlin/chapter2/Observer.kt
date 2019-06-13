package chapter2

import org.junit.Test

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 13.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class ObserverTest {
    @Test
    fun observerTest() {
        val weatherData = WeatherData()
        CurrentConditionDisplay(weatherData)
        weatherData.setMeasurements(80F, 65F, 30.4F)
        weatherData.setMeasurements(82F, 70F, 29.2F)
        weatherData.setMeasurements(78F, 90F, 29.2F)
    }
}
