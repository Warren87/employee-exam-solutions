package employees

import java.math.BigDecimal

class Restaurant(
        roomsCount: Int,
        hasKitchen: Boolean,
        bathroomsCount: Int,
        val employees: MutableSet<Employee> = mutableSetOf()
) : Building(roomsCount, hasKitchen, bathroomsCount) {


    val menu = Menu()

    fun findEmployeeByName(name: String) = employees.firstOrNull { name == it.fullName }

    fun add(employee: Employee) {
        employees.add(employee)
    }

    fun add(menuItem: MenuItem) {
        menu.add(menuItem)
    }

    fun findMenuItemByName(menuItemName: String): MenuItem? = menu.findByName(menuItemName)

    fun printMenu() {
        menu.print()
    }


}

class Menu {

    private val items = mutableSetOf<MenuItem>()

    fun add(menuItem: MenuItem) {
        items.add(menuItem)
    }

    fun findByName(name: String): MenuItem? = items.firstOrNull { name == it.name }

    fun print() {
        items.forEachIndexed { index, item -> println("$index. $item") }
    }

}

data class MenuItem(
        val name: String,
        val desc: String,
        val price: BigDecimal) {

    override fun toString() = "$name, $desc with price: ${price.toPlainString()}"

}