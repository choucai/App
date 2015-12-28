package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season;

import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.CondimentDecorator;

public class Milk extends CondimentDecorator {
	public Milk(com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return beverage.cost() + .10;
	}
}
