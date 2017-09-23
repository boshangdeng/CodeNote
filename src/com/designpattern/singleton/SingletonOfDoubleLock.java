package com.designpattern.singleton;

/**
 * 
 * @author wb
 * 单例模式线程安全方法：
 * 1、饿汉模式线程安全，但是不适用通过配置文件创建实例的情况
 * 2、懒汉模式getInstance()设为同步（synchronized）。解决线程安全问题，但不高效。
 * 3、双重检验锁
 * 4、静态内部类（Effective java推荐）
 * 5、枚举（最简单）
 */
public class SingletonOfDoubleLock {
	// 1.将构造方法私有化，不允许外边直接创建对象
	private SingletonOfDoubleLock() {

		}

	// 2.创建类的唯一实例,使用private static修饰
	private volatile static SingletonOfDoubleLock instance;

	// 3.提供一个用于获取实例的方法,使用public static修饰
	public static SingletonOfDoubleLock getInstance() {
		if (instance == null) {  //Single Checked
			synchronized(SingletonOfDoubleLock.class){  //Double Checked
				instance = new SingletonOfDoubleLock();//非原子操作，解决办法：将instance设置成volatile
			}
			return instance;
		} else
			return instance;
	}

}
