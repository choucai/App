package com.dream.java.pattern.dp01_strategy.fly;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
