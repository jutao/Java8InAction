package com.example.chapter2;

/**
 * Created by jutao on 2017/2/5.
 */

    public class AppleGreenColorPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }
