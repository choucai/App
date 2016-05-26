package com.dream.java.senior.annotation;

import java.util.HashMap;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * 编译时 Annotation 解析
 * <p/>
 * (1) 编译时 Annotation 指 @Retention 为 CLASS 的 Annotation，甴编译器自动解析。需要做的
 * a. 自定义类集成自 AbstractProcessor
 * b. 重写其中的 process 函数
 * <p/>
 * 实际是编译器在编译时自动查找所有继承自 AbstractProcessor 的类
 * 然后调用他们的 process 方法去处理.
 *
 * Java注解处理器
 * http://www.race604.com/annotation-processing/
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午5:47.
 * @phone 152-5320-8570
 */
@SupportedAnnotationTypes({"com.dream.java.senior.annotation.MethodInfo"})
public class MethodInfoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        HashMap<String, String> map = new HashMap<>();
        for (TypeElement te : annotations) {
            for (Element element : env.getElementsAnnotatedWith(te)) {
                MethodInfo methodInfo = element.getAnnotation(MethodInfo.class);
                map.put(element.getEnclosingElement().toString(), methodInfo.author());
            }
        }
        return false;
    }

}
