package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD}) //描述该注解能放在什么地方
@Retention(RetentionPolicy.RUNTIME) //描述注解的作用域（代码，class文件，运行时）
@Inherited
public @interface MyAnnotation{
    String[] value() default {"abc"};
}