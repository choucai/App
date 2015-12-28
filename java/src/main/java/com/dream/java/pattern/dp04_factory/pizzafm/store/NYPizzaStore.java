package com.dream.java.pattern.dp04_factory.pizzafm.store;

import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStyleCheesePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStyleClamPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStylePepperoniPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStyleVeggiePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}
