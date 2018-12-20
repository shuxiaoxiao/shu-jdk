package com.shuframework.jdkdemo.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 我的第一个注解
 * 
 * @author shu
 *
 */
//元注解  @Target、@Retention
//TYPE(类型) FIELD(属性字段) METHOD(方法)
@Target({TYPE, FIELD, METHOD})
//RUNTIME（保留到运行期间）、SOURCE（源文件期间）、CLASS（在class文件中存在,但JVM将会忽略）
@Retention(RetentionPolicy.RUNTIME)
//表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的
@Documented
public @interface MyAnno {

	//添加属性, 如果只有value 可以省略不写(给了default的属性可以理解为有默认值, 使用时可以不用指定)
	String value() default "";//使用时@MyAnno()
//	String value();	//使用时@MyAnno("")
//	String name() default "";//使用时@MyAnno() 或 @MyAnno("") 或 @MyAnno(value="", name="")
//	String name() ;
//	String[] names() ;
//	String[] names() default {};
}
