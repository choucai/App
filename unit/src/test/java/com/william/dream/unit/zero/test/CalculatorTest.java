package com.william.dream.unit.zero.test;


import com.william.dream.unit.zero.Calculator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/3
 * @phone 152-5320-8570
 */
public class CalculatorTest {

    Calculator mCalculator;

    /**
     * 如果一个方法被@Before修饰过了,那么在每个测试方法调用之前,这个方法都会得到调用
     * 对应于@Before的,有一个@After,作用估计你也猜得到,那就是每个测试方法运行结束之后,会得到运行的方法
     * <p>
     * 类似的，还有@BeforeClass和@AfterClass
     * 1-@BeforeClass的作用是，在跑一个测试类的所有测试方法之前，会执行一次被@BeforeClass修饰的方法
     * 执行完所有测试方法之后，会执行一遍被@AfterClass修饰的方法
     * 这两个方法可以用来setup和release一些公共的资源，需要注意的是，
     * 被这两个annotation修饰的方法必须是静态的
     */
    @Before
    public void setup() {
        mCalculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        int sum = mCalculator.add(1, 2);
        Assert.assertEquals(3, sum);
    }

    @Test
    public void testMultiply() throws Exception {
        int product = mCalculator.multiply(2, 4);
        Assert.assertEquals(6, product);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDivide() {
        mCalculator.divide(4, 0);
    }

    /**
     * 让JUnit忽略某些方法,让它在跑所有测试方法的时候不要跑这个测试方法
     */
    @Test
    @Ignore("not implemented yet")
    public void testFactorial() {

    }

}
