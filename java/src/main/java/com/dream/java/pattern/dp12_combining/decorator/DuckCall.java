package com.dream.java.pattern.dp12_combining.decorator;

public class DuckCall implements Quackable {
 
	public void quack() {
		System.out.println("Kwak");
	}
 
	public String toString() {
		return "Duck Call";
	}
}
