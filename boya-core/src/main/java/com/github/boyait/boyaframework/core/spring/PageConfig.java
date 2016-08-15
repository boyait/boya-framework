package com.github.boyait.boyaframework.core.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Page参数注解
 * 
 * @author L-liang
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageConfig {

	/**
	 * Page参数是否自动参与分页
	 */
	boolean pageable() default true;
	
	/**
	 * 注解配置每页条数
	 */
	int pageSize() default 10;
}
