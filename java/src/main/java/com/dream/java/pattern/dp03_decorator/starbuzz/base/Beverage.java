package com.dream.java.pattern.dp03_decorator.starbuzz.base;

/**
 *
 * 要装饰的基础组件-coffee.
 *
 * @author 李君波
 * @version V1.0.0
 * @date 2015-11-24
 */
public abstract class Beverage {

	protected String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
}
