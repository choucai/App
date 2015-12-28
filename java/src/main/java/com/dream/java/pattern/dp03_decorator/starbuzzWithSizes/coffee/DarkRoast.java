package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.coffee;

public class DarkRoast extends com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

