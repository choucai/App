package com.dream.java.pattern.dp04_factory.pizzaaf.factory;

import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.BlackOlives;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Eggplant;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.clams.FrozenClams;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.cheese.MozzarellaCheese;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.sauce.PlumTomatoSauce;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.pepperoni.SlicedPepperoni;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Spinach;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.dough.ThickCrustDough;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.cheese.Cheese;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.clams.Clams;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.dough.Dough;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.pepperoni.Pepperoni;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.sauce.Sauce;
import com.dream.java.pattern.dp04_factory.pizzaaf.products.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    public Dough createDough() {
        return new ThickCrustDough();
    }

    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(),
                new Spinach(),
                new Eggplant()};
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClam() {
        return new FrozenClams();
    }
}
