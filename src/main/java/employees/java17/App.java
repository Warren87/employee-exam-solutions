package employees.java17;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Comparator.comparing;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> AVAILABLE_POSITIONS = Arrays.stream(Position.values())
            .map(Position::name)
            .map(String::toLowerCase)
            .toList();

    public static void main(String[] args) {
        var sortedEmployees = new TreeSet<>(comparing(Employee::getFullName));
        Restaurant restaurant = new Restaurant(2, true, 2, sortedEmployees);

        int option = readMenuOption();

        while (isNotExitOption(option)) {
            executeOption(restaurant, option);
            option = readMenuOption();
        }
    }

    private static int readMenuOption() {
        var menu = """
                1. Find employee
                2. Add employee
                3. Add menu item
                4. Find menu item
                5. Print menu
                6. Print building status
                7. Print employees list
                8. Exit
                                
                Choose your option:
                """;

        System.out.println(menu);

        return scanner.nextInt();
    }

    private static void executeOption(Restaurant restaurant, int option) {
        switch (option) {
            case 1 -> findAndPrintEmployee(restaurant);
            case 2 -> addNewEmployeeTo(restaurant);
            case 3 -> addNewMenuItemTo(restaurant);
            case 4 -> findAndPrintMenuItem(restaurant);
            case 5 -> restaurant.getMenu().print();
            case 6 -> printBuildingInfo(restaurant);
            case 7 -> listEmployees(restaurant);
            default -> System.out.println("Option " + option + " doesn't exist. Try again\n");
        }
    }

    private static boolean isNotExitOption(int option) {
        return option != 8;
    }

    private static void findAndPrintEmployee(Restaurant restaurant) {
        System.out.println("Please enter employee full name");
        Optional<Employee> employee = restaurant.findEmployeeByName(scanner.next());
        employee.ifPresentOrElse(System.out::println,
                () -> System.out.println("Employee not found"));
    }

    private static void addNewEmployeeTo(Restaurant restaurant) {
        System.out.println("""
                Adding employee
                Please enter name
                """);
        String name = scanner.next();

        System.out.println("Please enter surname");
        String surname = scanner.next();

        System.out.println("Please enter position ( possible values " + AVAILABLE_POSITIONS + ")");
        Position position = Position.valueOf(scanner.next().toUpperCase());

        System.out.println("Please enter salary per hour");
        BigDecimal salaryPerHour = BigDecimal.valueOf(scanner.nextDouble());

        Employee newEmployee = new Employee(name, surname, position, salaryPerHour);
        restaurant.add(newEmployee);
    }

    private static void addNewMenuItemTo(Restaurant restaurant) {
        System.out.println("""
                Adding menu item
                Please enter name
                """);
        String menuName = scanner.next();

        System.out.println("Please enter description");
        String desc = scanner.next();

        System.out.println("Please enter price");
        BigDecimal price = BigDecimal.valueOf(scanner.nextDouble());

        restaurant.add(new MenuItem(menuName, desc, price));
    }

    private static void findAndPrintMenuItem(Restaurant restaurant) {
        System.out.println("Please enter menu item name to find");
        String menuItemName = scanner.next();

        Optional<MenuItem> foundMenuItem = restaurant.findMenuItemByName(menuItemName);
        foundMenuItem.ifPresentOrElse(item -> System.out.println("Found: " + item),
                () -> System.out.println("Not found"));
    }

    private static void printBuildingInfo(Restaurant restaurant) {
        System.out.println(restaurant);
    }

    private static void listEmployees(Restaurant restaurant) {
        restaurant.getEmployees().forEach(System.out::println);
    }
}
