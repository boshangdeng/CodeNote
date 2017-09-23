package com.designpattern.singleton;

/**
 * 
 * @author wb 懒汉模式 
 * 区别：饿汉模式的特点是加载时比较慢，但运行时获取对象的速度比较快，线程不安全
 *     懒汉模式的特点是加载类时比较快，但运行时获取对象速度比较慢，线程安全
 */
public class SingletonOfLazy {
	// 1.将构造方法私有化，不允许外边直接创建对象
	private SingletonOfLazy() {

	}

	// 2.创建类的唯一实例,使用private static修饰
	private static SingletonOfLazy instance;

	// 3.提供一个用于获取实例的方法,使用public static修饰
	public static synchronized SingletonOfLazy getInstance() {
		if (instance == null) {
			instance = new SingletonOfLazy();
			return instance;
		} else
			return instance;
	}

}
