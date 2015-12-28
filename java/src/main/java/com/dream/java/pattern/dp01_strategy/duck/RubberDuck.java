package com.dream.java.pattern.dp01_strategy.duck;

import com.dream.java.pattern.dp01_strategy.base.Duck;
import com.dream.java.pattern.dp01_strategy.fly.FlyNoWay;
import com.dream.java.pattern.dp01_strategy.quack.Squeak;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
