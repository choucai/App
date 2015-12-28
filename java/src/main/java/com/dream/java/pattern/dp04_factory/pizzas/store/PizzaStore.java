package com.dream.java.pattern.dp04_factory.pizzas.store;

import com.dream.java.pattern.dp04_factory.pizzas.factory.SimplePizzaFactory;

public class PizzaStore {

	SimplePizzaFactory factory;
 
	public PizzaStore(SimplePizzaFactory factory) { 
		this.factory = factory;
	}
 
	public com.dream.java.pattern.dp04_factory.pizzas.pizza.Pizza orderPizza(String type) {
		com.dream.java.pattern.dp04_factory.pizzas.pizza.Pizza pizza;
 
		pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
