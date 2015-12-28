package com.dream.java.pattern.dp05_singleton.dcl;

//
// Danger!  This implementation of Singleton not
// guaranteed to work prior to Java 5
//

/**
 * 单例模式---确保一个类只有一个实例，并提供全局访问点.
 *
 * 要点：
 * 单例模式确保程序中一个类最多只有一个实例
 * 单例模式也是提供访问这个实例的全局点
 * 在java中实现单例模式需要私有构造器，一个静态方法和一个静态变量
 * 确定在性能和资源上得限制然后小心地选择适当地方案来实现单件，以解决多线程的问题(我们必须认定所有的程序都是多线程的)
 * 如果不是采用第五版的Java 2，双重检查加锁实现会失效
 * 小心，你如果使用多个类加载器，可能会导致单例失效而产生多个实例
 * 如果使用JVM 1.2或之前的版本，你必须建立单件注册表，以免垃圾收集器将单件回收
 *
 * @author 李君波
 * @version V1.0.0
 * @date 2015-11-26
 */
public class Singleton {

	private volatile static Singleton uniqueInstance;
 
	private Singleton() {}
 
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}

}
