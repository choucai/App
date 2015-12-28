package com.dream.java.pattern.dp03_decorator.starbuzz.season;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;
import com.dream.java.pattern.dp03_decorator.starbuzz.base.CondimentDecorator;

public class Milk extends CondimentDecorator {

	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
