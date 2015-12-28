package com.dream.java.pattern.dp04_factory.pizzafm.store;

import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStyleCheesePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStyleClamPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStylePepperoniPizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.ChicagoStyleVeggiePizza;
import com.dream.java.pattern.dp04_factory.pizzafm.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
