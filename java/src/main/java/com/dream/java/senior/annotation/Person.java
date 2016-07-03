package com.dream.java.senior.annotation;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午5:05.
 * @phone 152-5320-8570
 */
public class Person {

    private int id;

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Person person) {
        return person.id == id;
    }

    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {

        Set<Person> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(new Person(i, "Jim"));
        }
        System.out.println(set.size());
    }

}
