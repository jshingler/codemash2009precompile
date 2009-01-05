package com.juddsolutions.services;

public class MyServiceImpl implements MyService {
	
	private Dependency depenency;

	public MyServiceImpl() {}
	
	public MyServiceImpl(Dependency dependency) {
		this.depenency = dependency;
	}

	public void blowup() {
		throw new UnsupportedOperationException();
	}
	
	public int calculate() {
		int i = depenency.slowResult();
		return i + 5;
	}

}
