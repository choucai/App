package com.dream.java.pattern.dp03_decorator.starbuzz.season;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;
import com.dream.java.pattern.dp03_decorator.starbuzz.base.CondimentDecorator;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
