package com.java.jvm.classloader;

/**
 * �Զ���һ��������������ڽ��ֽ���ת��Ϊclass����
 * 
 * @author wangbo
 *
 */
public class MyClassLoader extends ClassLoader {
	public Class<?> difineMyClass(byte[] b, int off, int len) {
		return super.defineClass(b, off, len);
	}
}
