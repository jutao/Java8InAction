package com.example.chapter2;

/**
 * Created by jutao on 2017/2/5.
 */

    public class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor())&&apple.getWeight()>200;
        }
    }
