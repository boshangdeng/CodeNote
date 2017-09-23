package com.designpattern.singleton;

/**
 * 
 * @author wb
 * 单例模式之静态内部类
 * 利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗
 */
public class SingletonOfStaticInnerClass {
	
	private static class SingletonHolder{
		private static final SingletonOfStaticInnerClass INSTANCE  = new SingletonOfStaticInnerClass();
	}
	
	private SingletonOfStaticInnerClass (){} 
	
    public static final SingletonOfStaticInnerClass getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
