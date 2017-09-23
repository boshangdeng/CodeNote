package com.designpattern.singleton;

/**
 * 
 * @author wb
 * ����ģʽ֮����ģʽ
 * Ӧ�ó��ϣ�ֻ��һ������ʵ�������
 * ���ã���֤����Ӧ�ó�����ĳ��ʵ��ֻ��һ��
 */
public class SingletonOfHungry {
	//1.�����췽��˽�л�
	private SingletonOfHungry(){
		
	}
	
	//2.�������Ψһʵ��,ʹ��private static����
	private static final SingletonOfHungry instance=new SingletonOfHungry();
	
	//3.�ṩһ�����ڻ�ȡʵ���ķ���,ʹ��public static����
	public static SingletonOfHungry getInstance(){
		return instance;
	}

}
