package com.designpattern.singleton;

/**
 * 
 * @author wb
 * ����ģʽ�̰߳�ȫ������
 * 1������ģʽ�̰߳�ȫ�����ǲ�����ͨ�������ļ�����ʵ�������
 * 2������ģʽgetInstance()��Ϊͬ����synchronized��������̰߳�ȫ���⣬������Ч��
 * 3��˫�ؼ�����
 * 4����̬�ڲ��ࣨEffective java�Ƽ���
 * 5��ö�٣���򵥣�
 */
public class SingletonOfDoubleLock {
	// 1.�����췽��˽�л������������ֱ�Ӵ�������
	private SingletonOfDoubleLock() {

		}

	// 2.�������Ψһʵ��,ʹ��private static����
	private volatile static SingletonOfDoubleLock instance;

	// 3.�ṩһ�����ڻ�ȡʵ���ķ���,ʹ��public static����
	public static SingletonOfDoubleLock getInstance() {
		if (instance == null) {  //Single Checked
			synchronized(SingletonOfDoubleLock.class){  //Double Checked
				instance = new SingletonOfDoubleLock();//��ԭ�Ӳ���������취����instance���ó�volatile
			}
			return instance;
		} else
			return instance;
	}

}
