package com.dream.java.pattern.dp01_strategy;

import com.dream.java.pattern.dp01_strategy.base.Duck;
import com.dream.java.pattern.dp01_strategy.duck.MallardDuck;
import com.dream.java.pattern.dp01_strategy.duck.ModelDuck;
import com.dream.java.pattern.dp01_strategy.fly.FlyRocketPowered;

public class MiniDuckSimulator1 {
 
	public static void main(String[] args) {
 
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

	}
}
