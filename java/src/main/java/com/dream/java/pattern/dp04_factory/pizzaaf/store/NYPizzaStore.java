package com.dream.java.pattern.dp04_factory.pizzaaf.store;

import com.dream.java.pattern.dp04_factory.pizzaaf.factory.NYPizzaIngredientFactory;
import com.dream.java.pattern.dp04_factory.pizzaaf.factory.PizzaIngredientFactory;
import com.dream.java.pattern.dp04_factory.pizzaaf.pizza.CheesePizza;
import com.dream.java.pattern.dp04_factory.pizzaaf.pizza.ClamPizza;
import com.dream.java.pattern.dp04_factory.pizzaaf.pizza.PepperoniPizza;
import com.dream.java.pattern.dp04_factory.pizzaaf.pizza.Pizza;
import com.dream.java.pattern.dp04_factory.pizzaaf.pizza.VeggiePizza;

public class NYPizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		} else if (item.equals("clam")) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
 
		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		return pizza;
	}
}
