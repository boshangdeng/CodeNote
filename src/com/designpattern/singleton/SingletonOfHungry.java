package com.designpattern.singleton;

/**
 * 
 * @author wb
 * 单例模式之饿汉模式
 * 应用场合：只需一个对象实例的情况
 * 作用：保证整个应用程序中某个实例只有一个
 */
public class SingletonOfHungry {
	//1.将构造方法私有化
	private SingletonOfHungry(){
		
	}
	
	//2.创建类的唯一实例,使用private static修饰
	private static final SingletonOfHungry instance=new SingletonOfHungry();
	
	//3.提供一个用于获取实例的方法,使用public static修饰
	public static SingletonOfHungry getInstance(){
		return instance;
	}

}
