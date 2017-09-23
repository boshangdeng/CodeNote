package com.designpattern.factory.abstracts;

public class IntelMainBoard implements MainBoard {
	/**
	 * CPU��۵Ŀ���
	 */
	private int cpuHoles = 0;

	/**
	 * ���췽��������CPU��۵Ŀ���
	 * 
	 * @param cpuHoles
	 */
	public IntelMainBoard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		System.out.println("Intel�����CPU��ۿ����ǣ�" + cpuHoles);
	}

}
