package employees

import java.math.BigDecimal

val availablePosition = Position.values().map { it.positionName }

const val menu = """
 1. Find employee
 2. Add employee
 3. Add menu item
 4. Find menu item
 5. Print menu
 6. Print building status
 7. Print employees list
 8. Exit
                 
 Choose your option:"""

fun main() {
    val sortedEmployees = sortedSetOf<Employee>(Comparator.comparing { e -> e.fullName })
    val restaurant = Restaurant(roomsCount = 2, hasKitchen = false, bathroomsCount = 2, employees = sortedEmployees)

    var option = readMenuOption()

    while (isNotExitOption(option)) {
        executeOption(restaurant, option)
        option = readMenuOption()
    }

}

fun readMenuOption(): Int {
    println(menu)
    return readln().toInt()
}

fun executeOption(restaurant: Restaurant, option: Int) {
    when (option) {
        1 -> findAndPrintEmployee(restaurant)
        2 -> addNewEmployeeTo(restaurant)
        3 -> addNewMenuItemTo(restaurant)
        4 -> findAndPrintMenuItem(restaurant)
        5 -> restaurant.printMenu()
        6 -> printBuildingInfo(restaurant)
        7 -> listEmployees(restaurant)
        else -> println("Option $option doesn't exist. Try again\n")
    }
}


private fun isNotExitOption(option: Int) = option != 8

private fun findAndPrintEmployee(restaurant: Restaurant) {
    println("Please enter employee full name")

    val employee = restaurant.findEmployeeByName(readln())

    println(employee ?: "Not found")
}


private fun addNewEmployeeTo(restaurant: Restaurant) {
    println("""
 Adding employee
 Please enter name
 """)
    val name = readln()

    println("Please enter surname")
    val surname = readln()

    println("Please enter position ( possible $availablePosition values )")
    val position = Position.valueOf(readln().uppercase())

    println("Please enter salary per hour")
    val salaryPerHour = BigDecimal.valueOf(readln().toDouble())

    restaurant.add(Employee(name = name,
            surname = surname,
            position = position,
            salaryPerHour = salaryPerHour))
}

private fun addNewMenuItemTo(restaurant: Restaurant) {
    println("""
 Adding menu item
 Please enter name
 """)
    val menuName = readln()

    println("Please enter description")
    val desc = readln()

    println("Please enter price")
    val price = BigDecimal.valueOf(readln().toDouble())

    restaurant.add(MenuItem(menuName, desc, price))
}

private fun findAndPrintMenuItem(restaurant: Restaurant) {
    println("Please enter menu item name to find")
    val menuItemName = readln()

    val menuItem = restaurant.findMenuItemByName(menuItemName)

    menuItem?.let { println("Found: $menuItem") } ?: println("Not found")
}

private fun printBuildingInfo(restaurant: Restaurant) {
    println(restaurant)
}

private fun listEmployees(restaurant: Restaurant) {
    restaurant.employees.forEach { println(it) }
}