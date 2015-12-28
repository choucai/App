package com.dream.java.pattern.dp03_decorator.starbuzz;

import com.dream.java.pattern.dp03_decorator.starbuzz.base.Beverage;
import com.dream.java.pattern.dp03_decorator.starbuzz.coffee.Espresso;
import com.dream.java.pattern.dp03_decorator.starbuzz.coffee.HouseBlend;
import com.dream.java.pattern.dp03_decorator.starbuzz.coffee.DarkRoast;
import com.dream.java.pattern.dp03_decorator.starbuzz.season.Mocha;
import com.dream.java.pattern.dp03_decorator.starbuzz.season.Soy;
import com.dream.java.pattern.dp03_decorator.starbuzz.season.Whip;

/**
 * 装饰者模式---动态地将责任附加到对象上。想要扩展功能，装饰者提供有别于继承的另一种选择.
 * <p/>
 * 原则：对扩展开发，对修改封闭
 * <p/>
 * 要点：
 * 继承属于扩展形式之一，但不见得是达到弹性设计的最佳方式
 * <p/>
 * 在我们的设计中，应该允许行为可以被扩展，而无需修改现有的代码
 * <p/>
 * 组合和委托可用于在运行时动态地加上新行为
 * <p/>
 * <p/>
 * 除了继承，装饰者模式也可以让我们扩展行为
 * <p/>
 * 装饰者模式意味着一群装饰者类，这些类用来包装具体组件
 * <p/>
 * 装饰者类反映出被装饰的组件类型(事实上，他们具有相同的类型，都经过接口或继承实现)
 * <p/>
 * 装饰者可以在被装饰者的行为前面或后面加上自己的行为，甚至将被装饰者的行为整个取代掉，而达到特定的目的
 * <p/>
 * 你可以用无数个装饰者包装一个组件
 * <p/>
 * 装饰者一边对组件的客户是透明的，除非客户程序依赖于组件的具体类型
 * <p/>
 * 装饰者会导致设计中出现许多小对象，如果过度使用，会让程序变得复杂
 *
 * @author 李君波
 * @version V1.0.0
 * @date 2015-11-24
 */
public class StarbuzzCoffee {

    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
