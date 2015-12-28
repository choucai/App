package com.dream.java.pattern.dp02_observer.weather;

import com.dream.java.pattern.dp02_observer.weather.observer.CurrentConditionsDisplay;
import com.dream.java.pattern.dp02_observer.weather.observer.ForecastDisplay;
import com.dream.java.pattern.dp02_observer.weather.observer.StatisticsDisplay;
import com.dream.java.pattern.dp02_observer.weather.subject.WeatherData;

/**
 * 观察者模式---在对象之间定义一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象都会收到通知，并自动更新.
 * 原则：为交互对象之间的松耦合设计而努力
 * 要点：
 *  观察者模式定义了对象之间一对多的关系
 *  主题(也就是可观察者)用一个共同的接口来更新观察者
 *  观察者和可观察者之间用松耦合方式结合，可观察者不知道观察者的细节，只知道观察者实现了观察者接口
 *  使用此模式时，你可以从被观察者处推(push)或拉(pull)数据，(然而，推的方式被认为更正确)
 *  有多个观察者时，不可以依赖特定的通知次序
 *  Javascript有多种观察者模式的实现，包括了通用的java.util.Observable
 *  要注意java.util.Observable实现上所带来的一些问题
 *  如果有必要的话，可以实现自己的Observable，这并不难，不要害怕
 *  Swing大量使用观察者模式，许多GUI框架也是如此
 *  此模式也被应用在很多地方，例如，JavaBean，RMI
 *
 * @author 李君波
 * @version V1.0.0
 * @date 2015-11-24
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
