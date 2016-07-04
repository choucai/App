package com.dream.java.think.think05;

/**
 * Created by William on 15/11/16.
 */
public class Book {

    boolean checkdOut = false;

    Book(boolean checkOut) {
        checkdOut = checkOut;
    }

    void checkIn() {
        checkdOut = false;
    }

    @Override
    protected void finalize() {

        System.out.print("finalize方法被调用.");

        if (checkdOut)
            System.out.print("Error:checked out.");
        // Normally,you'll also do this:

//        super.finalize();// Call the base-class version
    }
}
