package com.dream.java.pattern.dp01_strategy.duck;

import com.dream.java.pattern.dp01_strategy.base.Duck;
import com.dream.java.pattern.dp01_strategy.fly.FlyWithWings;
import com.dream.java.pattern.dp01_strategy.quack.Quack;

public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}
