package com.designpattern.factory.abstracts;

public class AmdMainBoard implements MainBoard {
	/**
	 * CPU��۵Ŀ���
	 */
	private int cpuHoles = 0;

	/**
	 * ���췽��������CPU��۵Ŀ���
	 * 
	 * @param cpuHoles
	 */
	public AmdMainBoard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		System.out.println("AMD�����CPU��ۿ����ǣ�" + cpuHoles);
	}
}
