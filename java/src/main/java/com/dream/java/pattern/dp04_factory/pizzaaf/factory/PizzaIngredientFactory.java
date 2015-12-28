package com.dream.java.pattern.dp04_factory.pizzaaf.factory;

import com.dream.java.pattern.dp04_factory.pizzaaf.products.cheese.Cheese;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.dough.Dough;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.sauce.Sauce;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Veggies;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.clams.Clams;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public com.dream.java.pattern.dp04_factory.pizzaaf.products.pepperoni.Pepperoni createPepperoni();
	public Clams createClam();
 
}
