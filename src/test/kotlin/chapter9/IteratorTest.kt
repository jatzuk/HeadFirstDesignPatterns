package chapter9

import org.junit.Test

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

class IteratorTest {
    @Test
    fun iteratorTest() {
//        val waitress = Waitress(PancakeHouseMenu(), DinnerMenu(), CafeMenu())
//        waitress.printMenu()
    }

    @Test
    fun compositeTest() {
        val pancakeHouseMenu = Menu("PANCAKE HOUSE MENU", "Breakfast")
        val dinnerMenu = Menu("DINNER MENU", "Launch")
        val cafeMenu = Menu("CAFE MENU", "Dinner")
        val dessertMenu = Menu("DESSERT MENU", "Dessert of course!")
        val menus = Menu("ALL MENUS", "All menus combined")
        menus.menuComponents.apply {
            add(pancakeHouseMenu)
            add(dinnerMenu)
            add(cafeMenu)
            add(dessertMenu)
        }

        dinnerMenu.menuComponents.add(
            MenuItem(
                "Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true,
                3.89
            )
        )

        dinnerMenu.menuComponents.add(dessertMenu)
        dessertMenu.menuComponents.add(
            MenuItem(
                "Apple Pie",
                "Apple Pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59
            )
        )

        Waitress(menus).printMenu()
    }
}
