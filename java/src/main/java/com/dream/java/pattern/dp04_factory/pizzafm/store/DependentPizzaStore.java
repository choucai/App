package com.dream.java.pattern.dp04_factory.pizzafm.store;

import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStyleCheesePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStyleClamPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStylePepperoniPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStyleVeggiePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStyleCheesePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStyleClamPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStylePepperoniPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.NYStyleVeggiePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.Pizza;

public class DependentPizzaStore {
 
	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		} else {
			System.out.println("Error: invalid type of pizza");
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
