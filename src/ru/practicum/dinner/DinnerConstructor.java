package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
public class DinnerConstructor {

    static Random rnd = new Random();
    HashMap<String, ArrayList<String>> menu;

    DinnerConstructor() {
        menu = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {
        if (menu.containsKey(dishType)) {
            menu.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(dishType, dishes);
        }
    }

    void generateDishCombos(int numberOfCombos, ArrayList<String> dishTypes) {

        if (dishTypes.isEmpty()) {
            System.out.println("Список типов блюд из которых вы хотите сделать комбо-обеды пуст!");
            System.out.println("Пожалуйста, добавьте, блюда");
        } else {
            for (int i = 0; i < numberOfCombos; i++) {
                ArrayList<String> combo = new ArrayList<>();
                for (String dishType : dishTypes) {
                    int dishPositionInArray = rnd.nextInt(menu.get(dishType).size());
                    combo.add(menu.get(dishType).get(dishPositionInArray));
                }

                System.out.println("Комбо " + (i+1));
                System.out.println(combo);
            }
        }

    }

    boolean checkType(String type) {
        return menu.containsKey(type);
    }
}
