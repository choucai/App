package com.dream.java.pattern.dp03_decorator.starbuzz.coffee;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

