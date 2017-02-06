package com.example.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pretty {
    public static void main(String[] args) {
//        List<Apple> inventory = new ArrayList<>();
//        inventory.add(new Apple("green"));
//        inventory.add(new Apple("green"));
//        inventory.add(new Apple("green"));
//        inventory.add(new Apple("red"));
//
//        List<Apple> greenApples = filterApples(inventory, (Apple apple)->"green".equals(apple.getColor()));
//        List<Apple> redApples = filterApples(inventory, "red",120,false);


        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(6);
//        numbers.add(82);
//        List<Integer> evenNumbers=filter(numbers,(i)->i%2==0);
//
//        for (Integer evenNumber : evenNumbers) {
//            System.out.println(evenNumber);
//        }
        //对苹果重量进行排序
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("green", 155));
        inventory.add(new Apple("green", 177));
        inventory.add(new Apple("green", 244));
        inventory.add(new Apple("red", 123));

        //原始方法
        //Collections.sort(inventory, new Comparator<Apple>() {
        //    @Override
        //    public int compare(Apple a1, Apple a2) {
        //        return a1.getWeight() > a2.getWeight() ? -1 : a1.getWeight() < a2.getWeight() ? 1 : 0;
        //    }
        //});

        //使用 Lambda 表达式
        Collections.sort(inventory, (a1, a2) -> a1.getWeight() > a2.getWeight() ? 1 : a1.getWeight() < a2.getWeight() ? -1 : 0);
        for (Apple apple : inventory) {
            System.out.println(apple.getWeight());
        }

        //用 Runnable 执行代码块
        new Thread(()->System.out.println("Hello world")).start();
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

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
