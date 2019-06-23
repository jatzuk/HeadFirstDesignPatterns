package chapter9

import kotlin.collections.MutableIterator

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

class MenuItem(
    val name: String,
    val description: String,
    val isVegetarian: Boolean,
    val price: Double
) : MenuComponent() {

    override fun print() {
        print("\t$name")
        if (isVegetarian) print("(v)")
        println(", $price$")
        println(" -- $description")
    }

    override fun createIterator(): Iterator<MenuComponent?> {
        return NullIterator().iterator()
    }
}

//interface Menu {
//    fun createIterator(): MutableIterator<MenuItem?>
//}

class PancakeHouseMenu {
    private val menuItems = ArrayList<MenuItem>()

    init {
        addItem(
            "K&B Pancake Breakfast",
            "Pancakes with scrambled eggs, and toast",
            true,
            2.99
        )

        addItem(
            "Regular Pancake Breakfast",
            "Pancakes with fried eggs, sausage",
            false,
            2.99
        )

        addItem(
            "Blueberry Pancakes",
            "Pancakes made with fresh blueberries",
            true,
            3.49
        )

        addItem(
            "Waffles",
            "Waffles with your choice of blueberries of strawberries",
            true,
            3.59
        )
    }

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        menuItems.add(MenuItem(name, description, vegetarian, price))
    }

//    override fun createIterator() = menuItems.iterator()
}

class DinnerMenu {
    private val menuItems = arrayOfNulls<MenuItem>(MAX_ITEMS)
    private var numberOfItems = 0

    init {
        addItem(
            "Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat",
            true,
            2.99
        )

        addItem(
            "BLT",
            "Bacon with lettuce & tomato on whole wheat",
            false,
            2.99
        )

        addItem(
            "Soup of the day",
            "Soup of the day, with a side of potato salad",
            false,
            3.29
        )

        addItem(
            "Hotdog",
            "A hot dog, with sauerkraut, relish, onions, topped with cheese",
            false,
            3.05
        )
    }

//    override fun createIterator() = DinnerMenuIterator(menuItems)

    @Throws(IllegalArgumentException::class)
    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        if (numberOfItems >= MAX_ITEMS) throw IllegalArgumentException("Sorry, menu is full!!")
        menuItems[numberOfItems++] = MenuItem(name, description, vegetarian, price)
    }

    companion object {
        const val MAX_ITEMS = 6
    }
}

class CafeMenu : Menu("", "") {
    private val menuItems = HashMap<String, MenuItem>()

    init {
        addItem(
            "Veggie Burger and Air Fries",
            "Veggie burger and a whole bun, lettuce, tomato, and fries",
            true,
            3.99
        )

        addItem(
            "Soup of the day",
            "A cup of the soup of the day, with a slide salad",
            false,
            3.69
        )

        addItem(
            "Burrito",
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true,
            4.29
        )
    }

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        menuItems[name] = MenuItem(name, description, vegetarian, price)
    }

//    override fun createIterator() = menuItems.values.iterator()
}

class DinnerMenuIterator(private val items: Array<MenuItem?>) : MutableIterator<MenuItem?> {
    private var index = 0

    override fun hasNext() = index < items.size

    override fun next() = items[index++]

    @Throws(IllegalStateException::class)
    override fun remove() {
        if (index <= 0) throw IllegalStateException("You can not remove an item until you've done at least one next()")
        if (items[index - 1] != null) {
            for (i in index - 1 until items.size - 1) items[i] = items[i + 1]
            items[items.size - 1] = null
        }
    }
}

class Waitress(
//    private val pancakeHouseMenu: Menu,
//    private val dinnerMenu: Menu,
//    private val cafeMenu: Menu
    private val menus: MenuComponent
) {
    fun printMenu() {
//        println("MENU\n----\nBREAKFAST")
//        printMenu(pancakeHouseMenu.createIterator())
//        println("\nLUNCH")
//        printMenu(dinnerMenu.createIterator())
//        println("\nDINNER")
//        printMenu(cafeMenu.createIterator())
        menus.print()
    }

    private fun printMenu(iterator: MutableIterator<MenuItem?>) {
        while (iterator.hasNext()) {
            with(iterator.next()) {
                this?.let {
                    println(name)
                    println(price)
                    println(description)
                }
            }
        }
    }
}
