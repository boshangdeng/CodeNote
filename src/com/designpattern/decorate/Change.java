package com.designpattern.decorate;

/**
 * ����װ�ν�ɫ����ʮ���䡱
 * 
 * @author wangbo Created on 2017��9��23�� ����11:46:32
 */
public class Change implements TheGreatestSage {
	private TheGreatestSage sage;

	public Change(TheGreatestSage sage) {
		this.sage = sage;
	}

	@Override
	public void move() {
		// ����
		sage.move();
	}

}
