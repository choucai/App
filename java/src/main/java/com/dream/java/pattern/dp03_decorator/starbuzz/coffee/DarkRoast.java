package com.dream.java.pattern.dp03_decorator.starbuzz.coffee;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return .99;
    }
}

