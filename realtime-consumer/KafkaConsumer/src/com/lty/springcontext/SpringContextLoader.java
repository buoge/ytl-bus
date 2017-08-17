package com.lty.springcontext;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringContextLoader {
  
	
	private static  ApplicationContext factory = null ;
	static{
			try {
			   factory = new ClassPathXmlApplicationContext("application-context.xml");
			} catch (Exception e) {
				e.printStackTrace();
			} 
	    }
	
	public static ApplicationContext getInstance(){
		return factory;
	}
}
