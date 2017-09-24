package com.designpattern.proxy.dynmic;

/**
 * ���ܳ��࣬ʵ��Rechargable��Vehicle�ӿ�
 * 
 * @author wangbo
 *
 */
public class ElectricCar implements Vehicle, Rechargable {

	@Override
	public void recharge() {
		System.out.println("Electric Car is Recharging...");
	}

	@Override
	public void drive() {
		System.out.println("Electric Car is Moving silently...");
	}

}
