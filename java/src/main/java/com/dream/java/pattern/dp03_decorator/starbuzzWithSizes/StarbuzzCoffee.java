package com.dream.java.pattern.dp03_decorator.starbuzzWithSizes;


import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.coffee.Espresso;
import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.coffee.HouseBlend;
import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season.Soy;
import com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season.Whip;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + String.format("%.2f", beverage.cost()));
 
		com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage beverage2 = new com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.coffee.DarkRoast();
		beverage2 = new com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season.Mocha(beverage2);
		beverage2 = new com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season.Mocha(beverage2);
		beverage2 = new com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season.Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + String.format("%.2f", beverage2.cost()));
 
		com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage beverage3 = new HouseBlend();
		beverage3.setSize(com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.base.Beverage.Size.VENTI);
		beverage3 = new Soy(beverage3);
		beverage3 = new com.dream.java.pattern.dp03_decorator.starbuzzWithSizes.season.Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + String.format("%.2f", beverage3.cost()));
	}
}
