package com.juddsolutions.services

public class MyGroovyServiceImpl implements MyService{
	
	def depenency
	
	public MyGroovyServiceImpl() {}
	
	public MyGroovyServiceImpl(dependency) {
		this.depenency = dependency
	}
	
	public int calculate(){
		int i = depenency.slowResult();
		return i + 5;
	}
	
	public int internalCalculate() {
		int i = internalSlowResult();
		return i + 5;
	}
	
	int internalSlowResult() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		return (int) (Math.random() * 100);
	}

	public void blowup(){}
}
