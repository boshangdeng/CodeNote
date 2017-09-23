package com.designpattern.decorate;

/**
 * 具体装饰角色“鱼儿”
 * 
 * @author wangbo Created on 2017年9月23日 下午11:49:01
 */
public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		// 代码
		System.out.println("Fish Move");
	}
}
