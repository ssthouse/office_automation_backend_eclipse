package com.ssthouse.officeautomation.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssthouse.officeautomation.util.Log;

public abstract class BaseController<T> {
	
	public abstract Class<T> getServiceClass();

	private T mService;
	
	public T getService(){
		if(mService == null){
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			mService =  context.getBean(getServiceClass());
			if(mService == null)
				Log.error("why is null?");
		}
		return mService;
	}
}
