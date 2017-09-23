package com.designpattern.decorate;

/**
 * 抽象装饰角色“七十二变”
 * 
 * @author wangbo Created on 2017年9月23日 下午11:46:32
 */
public class Change implements TheGreatestSage {
	private TheGreatestSage sage;

	public Change(TheGreatestSage sage) {
		this.sage = sage;
	}

	@Override
	public void move() {
		// 代码
		sage.move();
	}

}
