package com.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {

	public static void main(String[] args) {
		Programmer progammer = new Programmer();

		Hacker hacker = new Hacker();
		// cglib �м�ǿ��������������̬����
		Enhancer enhancer = new Enhancer();
		// ����Ҫ������̬�������
		enhancer.setSuperclass(progammer.getClass());
		// ���ûص��������൱���Ƕ��ڴ����������з����ĵ��ã��������CallBack����Callback����Ҫʵ��intercept()������������
		enhancer.setCallback(hacker);
		Programmer proxy = (Programmer) enhancer.create();
		proxy.code();

	}

}
