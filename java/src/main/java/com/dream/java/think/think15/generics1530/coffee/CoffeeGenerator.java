//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package com.dream.java.think.think15.generics1530.coffee;

import com.dream.java.think.net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;


public class CoffeeGenerator implements Generator<com.dream.java.think.think15.generics1530.coffee.Coffee>, Iterable<com.dream.java.think.think15.generics1530.coffee.Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, com.dream.java.think.think15.generics1530.coffee.Americano.class, com.dream.java.think.think15.generics1530.coffee.Breve.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator() {

    }

    // For iteration:
    private int size = 0;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    public com.dream.java.think.think15.generics1530.coffee.Coffee next() {
        try {
            return (com.dream.java.think.think15.generics1530.coffee.Coffee) types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<com.dream.java.think.think15.generics1530.coffee.Coffee> {

        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public com.dream.java.think.think15.generics1530.coffee.Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }


    public Iterator<com.dream.java.think.think15.generics1530.coffee.Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for (com.dream.java.think.think15.generics1530.coffee.Coffee c : new CoffeeGenerator(5))
            System.out.println(c);
    }
}
/* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~
