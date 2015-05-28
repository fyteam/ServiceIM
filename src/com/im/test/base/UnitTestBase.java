package com.im.test.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnitTestBase {

	private ClassPathXmlApplicationContext context;
	
	private String springXmlpath;

	public UnitTestBase(String stringXmlPath) {
		this.springXmlpath = stringXmlPath;
	}
	
	@Before
	public void before(){
		if(springXmlpath.equals("") || springXmlpath == null){
			springXmlpath = "classpath*:spring/spring-*.xml";
		}
		context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
		context.start();
	}
	
	@After
	public void after(){
		context.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {
		try {
			return (T)context.getBean(beanId);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T extends Object> T getBean(Class<T> clazz) {
		try {
			return context.getBean(clazz);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
}
