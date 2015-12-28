package com.dream.java.pattern.dp04_factory.pizzas;

/**
 *工厂模式---工厂方法模式&抽象工厂模式.
 * 工厂方法模式：定义了一个创建对象的接口，但由于子类决定要实例化的类是哪一个，工厂方法让类把实例化推迟到子类
 * 抽象工厂模式：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
 *
 * OO原则：依赖抽象，不要依赖具体类
 *
 * OO要点：
 * 所有的工厂都是用来封装对象的创建
 * 简单工厂，虽然不是真正的设计模式，但仍不失为一个简单的方法，可以将客户程序从具体类解耦
 * 工厂方法使用继承：把对象的创建委托给子类，子类实现工厂方法来创建对象
 * 抽象工厂使用对象组合：对象的创建被实现在工厂接口所暴露出来的方法中
 * 所有工厂模式都通过减少应用程序和具体类之间的依赖促进松耦合
 * 工厂方法允许类将实例化延迟到子类进行
 * 抽象工厂创建相关的对象家族，而不需要依赖它们的具体类
 * 依赖倒置原则，指导我们避免依赖具体类型，而要尽量依赖抽象
 * 工厂是很有威力的技巧，帮助我们针对抽象编程，而不是针对具体类编程
 *
 *
 * @author 李君波
 * @version V1.0.0
 * @date 2015-11-26
 */
public class PizzaTestDrive {
 
	/*public static void main(String[] args) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
	}*/
}
