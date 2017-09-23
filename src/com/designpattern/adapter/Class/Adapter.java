package com.designpattern.adapter.Class;

public class Adapter extends Adaptee implements Target {
	/**
	 * 由于源类Adaptee没有方法sampleOperation2() 因此适配器补充上这个方法
	 */
	@Override
	public void sampleOperation2() {
		/**
		 * 实现具体业务逻辑
		 */
	}

}
