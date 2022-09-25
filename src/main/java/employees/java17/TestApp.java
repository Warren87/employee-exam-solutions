package employees.java17;

import java.math.BigDecimal;
import java.util.HashSet;

import static employees.java17.Position.WAITER;


public class TestApp {

    public static void main(String[] args) {
        System.out.println(new Restaurant(2, true, 2, new HashSet<>()));
        System.out.println();
        System.out.println(new Restaurant(3, false, 1, new HashSet<>()));

        System.out.println(new Employee("Karol", "Okrasa", WAITER, BigDecimal.valueOf(25.0)));

        Menu menu = new Menu();
        menu.add(new MenuItem("Fries", "Chopped and fried potatoes", BigDecimal.valueOf(12.5)));

        menu.findByName("Fries").ifPresent(foundMenuItem -> System.out.println("Found: " + foundMenuItem));

        menu.add(new MenuItem("Cola", "Great sparkly drink", BigDecimal.valueOf(7.99)));
        menu.add(new MenuItem("Nuggets", "Ground chicken", BigDecimal.valueOf(25.0)));

        menu.print();
    }
}
