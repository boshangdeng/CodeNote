package com.java.generics;

interface Dog {
	void shout();
}

interface Cat {
	void run();
}

interface Pig {
	void eat();
}

/**
 * ���ͱ߽磬extends ������ĵ�һ���߽磬����Ϊ���ӿڣ�֮��ľ�Ϊ�ӿ�
 * 
 * @author wangbo
 *
 * @param <T>
 */
public class TestBorder<T extends Dog & Cat & Pig> {
	T t;

	public TestBorder(T t) {
		this.t = t;
	}

	public void test() {
		t.shout();
		t.run();
		t.eat();
	}

}
