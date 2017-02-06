package com.example.chapter2;

/**
 * Created by jutao on 2017/2/5.
 */

public class Apple {
    private String color;
    private int weight;

    public Apple(String color) {
        this.color = color;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }
}
