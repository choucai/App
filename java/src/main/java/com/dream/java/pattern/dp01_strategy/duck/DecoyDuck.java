package com.dream.java.pattern.dp01_strategy.duck;

import com.dream.java.pattern.dp01_strategy.base.Duck;
import com.dream.java.pattern.dp01_strategy.fly.FlyNoWay;
import com.dream.java.pattern.dp01_strategy.quack.MuteQuack;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
