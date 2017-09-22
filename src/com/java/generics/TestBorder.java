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
 * 泛型边界，extends 后面跟的第一个边界，可以为类或接口，之后的均为接口
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
