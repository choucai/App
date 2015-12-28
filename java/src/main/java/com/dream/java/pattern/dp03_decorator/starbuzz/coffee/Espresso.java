package com.dream.java.pattern.dp03_decorator.starbuzz.coffee;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;

public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

