package com.juddsolutions.services;

public class DependencyImpl implements Dependency {

	@Override
	public int slowResult() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		return (int) (Math.random() * 100);
	}

}
