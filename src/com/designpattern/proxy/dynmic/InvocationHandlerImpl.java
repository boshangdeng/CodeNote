package com.designpattern.proxy.dynmic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类处理的逻辑很简单：在调用某个方法前及方法后做一些额外的业务。换一种思路就是：在触发（invoke）真实角色的方法之前或者之后做一些额外的业务。那么，
 * 为了构造出具有通用性和简单性的代理类，可以将所有的触发真实角色动作交给一个触发的管理器，让这个管理器统一地管理触发。这种管理器就是Invocation
 * Handler。
 * 
 * @author wangbo
 *
 */
public class InvocationHandlerImpl implements InvocationHandler {
	private ElectricCar car;

	public InvocationHandlerImpl(ElectricCar car) {
		this.car = car;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("You are going to invoke " + method.getName() + " ...");
		method.invoke(car, null);
		System.out.println(method.getName() + " invocation Has Been finished...");
		return null;
	}

}
