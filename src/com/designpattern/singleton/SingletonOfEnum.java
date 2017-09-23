package com.designpattern.singleton;

public enum SingletonOfEnum {
	INSTANCE;
	
	public void test(){
		System.out.println("我是单例枚举类");
	}
}
