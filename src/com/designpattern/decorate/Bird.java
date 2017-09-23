package com.designpattern.decorate;

/**
 * 具体装饰角色“鸟儿”
 * 
 * @author wangbo Created on 2017年9月23日 下午11:52:07
 */
public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		// 代码
		System.out.println("Bird Fly");
	}

}
