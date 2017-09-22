package com.java.generics;

import java.lang.reflect.Array;

class A {
}

class B extends A {

}

/**
 * ������Ͳ�������instanceOfʧ������
 * 
 * @author wangbo
 *
 * @param <T>
 */
public class TestInstance<T> {
	private Class<T> t;

	public TestInstance(Class<T> t) {
		this.t = t;
	}

	public boolean compare(Object object) {
		return t.isInstance(object);

	}

	public T[] create(int size) {
		return (T[]) Array.newInstance(t, size);
	}

	public static void main(String[] args) {
		TestInstance<A> ti = new TestInstance<>(A.class);
		System.out.println(ti.compare(new A()));
		System.out.println(ti.compare(new B()));

		// ������������
		TestInstance<Integer> tInteger = new TestInstance<>(Integer.class);
		Integer[] array=tInteger.create(10);
		System.out.println(array.length);
	}
}
