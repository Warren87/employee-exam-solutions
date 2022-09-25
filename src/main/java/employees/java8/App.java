package employees.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> AVAILABLE_POSITIONS = Arrays.stream(Position.values())
            .map(Position::name)
            .map(String::toLowerCase)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        TreeSet<Employee> sortedEmployees = new TreeSet<>(Comparator.comparing(e -> e.fullName));
        Restaurant restaurant = new Restaurant(2, true, 2, sortedEmployees);

        int option = readMenuOption();

        while (isNotExitOption(option)) {
            executeOption(restaurant, option);
            option =  readMenuOption();
        }
    }

    private static int readMenuOption() {
        System.out.println("1. Find employee");
        System.out.println("2. Add employee");
        System.out.println("3. Add menu item");
        System.out.println("4. Find menu item");
        System.out.println("5. Print menu");
        System.out.println("6. Print building status");
        System.out.println("7. Print employees list");
        System.out.println("8. Exit");

        System.out.println("\nChoose your option:");

        return scanner.nextInt();
    }

    private static void executeOption(Restaurant restaurant, int option) {
        switch (option) {
            case 1:
                findAndPrintEmployee(restaurant);
                break;
            case 2:
                addNewEmployeeTo(restaurant);
                break;
            case 3:
                addNewMenuItemTo(restaurant);
                break;
            case 4:
                findAndPrintMenuItem(restaurant);
                break;
            case 5:
                restaurant.getMenu().print();
                break;
            case 6:
                printBuildingInfo(restaurant);
                break;
            case 7:
                listEmployees(restaurant);
                break;
            default:
                System.out.println("Option " + option + " doesn't exist. Try again\n");
        }
    }

    private static boolean isNotExitOption(int option) {
        return option != 8;
    }

    private static void findAndPrintEmployee(Restaurant restaurant) {
        System.out.println("Please enter employee full name");
        Optional<Employee> employee = restaurant.findEmployeeByName(scanner.next());

        String text = employee.map(Employee::toString).orElse("Employee not found");
        System.out.println(text);
    }

    private static void addNewEmployeeTo(Restaurant restaurant) {
        System.out.println("Adding employee");
        System.out.println("Please enter name");
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
        System.out.println("Adding menuItem");
        System.out.println("Please enter name");
        String menuName = scanner.next();

        System.out.println("Please enter description");
        String desc = scanner.next();

        System.out.println("Please enter price");
        BigDecimal price = BigDecimal.valueOf(scanner.nextDouble());

        MenuItem menuItem = new MenuItem(menuName, desc, price);

        restaurant.add(menuItem);
    }

    private static void findAndPrintMenuItem(Restaurant restaurant) {
        System.out.println("Please enter menu item name to find");
        String menuItemName = scanner.next();

        Optional<MenuItem> foundMenuItem = restaurant.findMenuItemByName(menuItemName);
        String text = foundMenuItem.map(MenuItem::toString).orElse("Not found");
        System.out.println(text);
    }

    private static void printBuildingInfo(Restaurant restaurant) {
        System.out.println(restaurant);
    }

    private static void listEmployees(Restaurant restaurant) {
        restaurant.getEmployees().forEach(System.out::println);
    }
}
