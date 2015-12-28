package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.coffee;

public class Decaf extends com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

