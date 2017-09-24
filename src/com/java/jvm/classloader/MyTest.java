package com.java.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyTest {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// ��ȡ���ص�class�ļ��ڵ��ֽ��룬ת�����ֽ�������
		File file = new File(".");
		InputStream input = new FileInputStream(
				"E:/project/interview/CodeNote/bin/com/java/jvm/classloader/Programmer.class");
		byte[] result = new byte[1024];
		int count = input.read(result);

		// ʹ���Զ������������� byte�ֽ�������ת��Ϊ��Ӧ��class����
		MyClassLoader loader = new MyClassLoader();
		Class clazz = loader.difineMyClass(result, 0, count);
		// ���Լ����Ƿ�ɹ�����ӡclass ���������
		System.out.println(clazz.getCanonicalName());

		// ʵ����һ��Programmer����
		Object o = clazz.newInstance();
		clazz.getMethod("code", null).invoke(o, null);
	}

}
