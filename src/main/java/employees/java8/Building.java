package employees.java8;

abstract class Building {

    final int roomsCount;

    final boolean hasKitchen;

    final int bathroomsCount;

    protected Building(int roomsCount, boolean hasKitchen, int bathroomsCount) {
        this.roomsCount = roomsCount;
        this.hasKitchen = hasKitchen;
        this.bathroomsCount = bathroomsCount;
    }

    @Override
    public String toString() {
        return " *** Building status *** \n"
                + " Building has " + roomsCount + " room(s) and" + (hasKitchen ? "" : " no" )
                + " kitchen. Also with " + bathroomsCount + " bathroom(s).\n"
                + " *** End of building status ***";
    }
}
