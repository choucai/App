package com.dream.java.pattern.dp04_factory.pizzaaf.factory;

import com.dream.java.pattern.dp04_factory.pizzaaf.products.clams.FreshClams;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Garlic;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.sauce.MarinaraSauce;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Mushroom;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Onion;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.RedPepper;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.cheese.ReggianoCheese;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.pepperoni.SlicedPepperoni;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.dough.ThinCrustDough;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.cheese.Cheese;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.clams.Clams;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.dough.Dough;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.pepperoni.Pepperoni;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.sauce.Sauce;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
