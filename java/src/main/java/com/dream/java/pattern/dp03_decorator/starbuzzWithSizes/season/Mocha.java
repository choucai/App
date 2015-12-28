package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season;

import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.CondimentDecorator;

public class Mocha extends CondimentDecorator {
	public Mocha(com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return beverage.cost() + .20;
	}
}
