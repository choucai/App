package com.dream.java.pattern.dp03_decorator.starbuzz.coffee;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}
 
	public double cost() {
		return .89;
	}
}

