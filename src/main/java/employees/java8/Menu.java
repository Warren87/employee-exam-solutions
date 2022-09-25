package employees.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Menu {

    int position = 0;
    final Map<Integer, MenuItem> menuItems = new HashMap<>();

    void add(MenuItem item) {
        menuItems.put(++position, item);
        System.out.println(item.getName() + " was added into menu on position: " + position);
    }

    public Optional<MenuItem> findByName(String name) {
        return menuItems.values().stream()
                .filter(menuItem -> menuItem.getName().equals(name))
                .findFirst();
    }

    public void print() {
        menuItems.forEach((position, item) -> System.out.println(position + ". " + item));
    }
}
