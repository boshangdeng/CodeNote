package com.designpattern.decorate;

/**
 * 具体构件角色“大圣本尊”猢狲类
 * 
 * @author wangbo Created on 2017年9月23日 下午11:45:47
 */
public class Monkey implements TheGreatestSage {

	@Override
	public void move() {
		System.out.println("Monkey run");
	}

}
