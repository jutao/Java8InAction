package com.example.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Pretty {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("red"));

        List<Apple> greenApples = filterApples(inventory, "green",150,true);
        List<Apple> redApples = filterApples(inventory, "red",120,false);

        System.out.println(greenApples.size());
        System.out.println(redApples.size());
    }

    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
