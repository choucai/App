package com.dream.java.pattern.dp03_decorator.starbuzz.season;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;
import com.dream.java.pattern.dp03_decorator.starbuzz.base.CondimentDecorator;

public class Whip extends CondimentDecorator {
	Beverage beverage;
 
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
