package com.designpattern.singleton;

/**
 * 
 * @author wb ����ģʽ 
 * ���𣺶���ģʽ���ص��Ǽ���ʱ�Ƚ�����������ʱ��ȡ������ٶȱȽϿ죬�̲߳���ȫ
 *     ����ģʽ���ص��Ǽ�����ʱ�ȽϿ죬������ʱ��ȡ�����ٶȱȽ������̰߳�ȫ
 */
public class SingletonOfLazy {
	// 1.�����췽��˽�л������������ֱ�Ӵ�������
	private SingletonOfLazy() {

	}

	// 2.�������Ψһʵ��,ʹ��private static����
	private static SingletonOfLazy instance;

	// 3.�ṩһ�����ڻ�ȡʵ���ķ���,ʹ��public static����
	public static synchronized SingletonOfLazy getInstance() {
		if (instance == null) {
			instance = new SingletonOfLazy();
			return instance;
		} else
			return instance;
	}

}
