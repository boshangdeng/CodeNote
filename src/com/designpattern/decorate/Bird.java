package com.designpattern.decorate;

/**
 * ����װ�ν�ɫ�������
 * 
 * @author wangbo Created on 2017��9��23�� ����11:52:07
 */
public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		// ����
		System.out.println("Bird Fly");
	}

}
