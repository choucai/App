package com.dream.java.pattern.dp01_strategy;

import com.dream.java.pattern.dp01_strategy.base.Duck;
import com.dream.java.pattern.dp01_strategy.duck.DecoyDuck;
import com.dream.java.pattern.dp01_strategy.duck.MallardDuck;
import com.dream.java.pattern.dp01_strategy.duck.ModelDuck;
import com.dream.java.pattern.dp01_strategy.duck.RubberDuck;
import com.dream.java.pattern.dp01_strategy.fly.FlyRocketPowered;


/**
 * 1、OO基础 --- 抽象 多态 封装 继承
 * 2、OO原则 --- 封装变化|多用组合,少用继承|针对接口编程,而不是针对实现编程
 * 3、OO模式 --- 策略模式
 * 		定义算法族,分别封装起来,让它们之间可以互相替换,此模式让算法的变化独立于使用算法的客户
 *
 * 良好的OO设计必须具备可复用、可扩充、可维护三个特性
 * 模式可以让我们建造出具有良好OO设计质量的系统
 * 模式被认为是历经验证的OO设计经验
 * 模式不是代码,而是针对设计问题的通用解决方案.你可以把它们应用到特定的应用中
 * 模式不是被发明,而是被发现
 * 大多数的模式和原则,都着眼于软件变化的主题
 * 大多数模式都允许系统局部改变独立于其他部分
 * 我们把系统变化的部分抽出来疯转
 * 模式让开发人员之间有共享的语言,能够最大化沟通的价值
 *
 * @author 李君波
 * @version V1.0.0
 * @date 2015-11-23
 */

public class MiniDuckSimulator {
 
	public static void main(String[] args) {
 
		MallardDuck mallard = new MallardDuck();
		RubberDuck rubberDuckie = new RubberDuck();
		DecoyDuck decoy = new DecoyDuck();
 
		Duck model = new ModelDuck();

		mallard.performQuack();
		rubberDuckie.performQuack();
		decoy.performQuack();
   
		model.performFly();	
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
