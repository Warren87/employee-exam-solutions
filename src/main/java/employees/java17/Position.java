package employees.java17;

enum Position {
    WAITER("Waiter"),
    COOK("Cook");

    private final String desc;

    Position(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
