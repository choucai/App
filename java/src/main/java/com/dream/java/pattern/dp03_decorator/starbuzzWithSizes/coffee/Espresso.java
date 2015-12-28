package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.coffee;

public class Espresso extends com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

