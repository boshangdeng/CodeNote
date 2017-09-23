package com.designpattern.decorate;

/**
 * ����װ�ν�ɫ�������
 * 
 * @author wangbo Created on 2017��9��23�� ����11:49:01
 */
public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		// ����
		System.out.println("Fish Move");
	}
}
