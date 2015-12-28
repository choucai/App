package com.dream.java.pattern.dp04_factory.pizzas.factory;

import com.dream.java.pattern.dp04_factory.pizzas.pizza.ClamPizza;
import com.dream.java.pattern.dp04_factory.pizzas.pizza.PepperoniPizza;
import com.dream.java.pattern.dp04_factory.pizzas.pizza.Pizza;

public class SimplePizzaFactory {

	public com.dream.java.pattern.dp04_factory.pizzas.pizza.Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("cheese")) {
			pizza = new com.dream.java.pattern.dp04_factory.pizzas.pizza.CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new com.dream.java.pattern.dp04_factory.pizzas.pizza.VeggiePizza();
		}
		return pizza;
	}
}
