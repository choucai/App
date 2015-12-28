package com.dream.java.pattern.dp04_factory.pizzaaf.pizza;

import com.dream.java.pattern.dp04_factory.pizzaaf.factory.PizzaIngredientFactory;

public class PepperoniPizza extends com.dream.java.pattern.dp04_factory.pizzaaf.pizza.Pizza {
	com.dream.java.pattern.dp04_factory.pizzaaf.factory.PizzaIngredientFactory ingredientFactory;
 
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
		pepperoni = ingredientFactory.createPepperoni();
	}
}
