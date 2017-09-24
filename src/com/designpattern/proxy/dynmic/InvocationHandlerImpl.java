package com.designpattern.proxy.dynmic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * �����ദ����߼��ܼ򵥣��ڵ���ĳ������ǰ����������һЩ�����ҵ�񡣻�һ��˼·���ǣ��ڴ�����invoke����ʵ��ɫ�ķ���֮ǰ����֮����һЩ�����ҵ����ô��
 * Ϊ�˹��������ͨ���Ժͼ��ԵĴ����࣬���Խ����еĴ�����ʵ��ɫ��������һ�������Ĺ������������������ͳһ�ع����������ֹ���������Invocation
 * Handler��
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
