package employees

sealed class Building(
        val roomsCount: Int,
        val hasKitchen: Boolean,
       val bathroomsCount: Int) {

    override fun toString() = """
 *** Building status ***
 Building has $roomsCount room(s) and ${if(hasKitchen) "" else "no"} and $bathroomsCount bathroom(s).
 *** End building status ***
    """.trimIndent()
}


