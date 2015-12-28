package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season;

import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.CondimentDecorator;

public class Soy extends CondimentDecorator {
	public Soy(com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		double cost = beverage.cost();
		if (beverage.getSize() == Size.TALL) {
			cost += .10;
		} else if (beverage.getSize() == Size.GRANDE) {
			cost += .15;
		} else if (beverage.getSize() == Size.VENTI) {
			cost += .20;
		}
		return cost;
	}
}
