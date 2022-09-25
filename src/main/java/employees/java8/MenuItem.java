package employees.java8;

import java.math.BigDecimal;

class MenuItem {
    final String name;

    final String description;

    final BigDecimal price;

    MenuItem(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ", " + description + " withi price: " + price.toPlainString();
    }
}
