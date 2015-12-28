package com.dream.java.pattern.dp01_strategy.base;

import com.dream.java.pattern.dp01_strategy.fly.FlyBehavior;
import com.dream.java.pattern.dp01_strategy.quack.QuackBehavior;

public abstract class Duck {

	protected FlyBehavior flyBehavior;

	protected QuackBehavior quackBehavior;

	public Duck() {

	}

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	protected abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
