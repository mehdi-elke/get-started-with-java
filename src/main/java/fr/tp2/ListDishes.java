package fr.tp2;

import java.util.HashMap;
import java.util.Map;

public class ListDishes {
    Map<Dish, Integer> dishMap = new HashMap<>();

    public ListDishes addDish(Dish dish, int quantity) {
        dishMap.put(dish, quantity);
        return this;
    }

    public void removeDish(Dish dish) {
        dishMap.remove(dish);
    }

    public Map<Dish, Integer> getDishes() {
        return dishMap;
    }

}
