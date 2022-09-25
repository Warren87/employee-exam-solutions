package employees.java8;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class Restaurant extends Building {

    Set<Employee> employees;

    Menu menu = new Menu();

    public Restaurant(int roomsCount, boolean hasKitchen, int bathroomsCount, Set<Employee> employees) {
        super(roomsCount, hasKitchen, bathroomsCount);
        this.employees = employees;
    }

    public Optional<Employee> findEmployeeByName(String fullName) {
        return employees.stream()
                .filter(employee -> employee.getFullName().equalsIgnoreCase(fullName))
                .findFirst();
    }

    public void add(Employee newEmployee) {
        employees.add(newEmployee);
    }

    public void add(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public Optional<MenuItem> findMenuItemByName(String menuItemName) {
        return menu.findByName(menuItemName);
    }

    public Menu getMenu() {
        return menu;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
