package com.designpattern.singleton;

/**
 * 
 * @author wb
 * ����ģʽ֮��̬�ڲ���
 * ������classloader�Ļ�������֤��ʼ��instanceʱֻ��һ���̣߳�����Ҳ���̰߳�ȫ�ģ�ͬʱû���������
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
