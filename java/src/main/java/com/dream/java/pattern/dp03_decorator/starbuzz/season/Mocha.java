package com.dream.java.pattern.dp03_decorator.starbuzz.season;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;
import com.dream.java.pattern.dp03_decorator.starbuzz.base.CondimentDecorator;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return .20 + beverage.cost();
    }
}
