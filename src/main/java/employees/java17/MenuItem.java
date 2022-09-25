package employees.java17;

import java.math.BigDecimal;

record MenuItem(String name,
                String description,
                BigDecimal price) {

    @Override
    public String toString() {
        return name + ", " + description + " with price: " + price.toPlainString();
    }
}
