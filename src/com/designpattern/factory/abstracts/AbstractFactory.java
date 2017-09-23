package com.designpattern.factory.abstracts;
/**
 * ���󹤳�ģʽ�빤������ģʽ�������������ڣ���������ģʽ��Ե���һ����Ʒ�ȼ��ṹ�������󹤳�ģʽ����Ҫ��Զ����Ʒ�ȼ��ṹ��
 * @author wangbo
 * Created on 2017��9��23�� ����8:02:07
 */
public interface AbstractFactory {
	/**
	 * ����CPU����
	 * 
	 * @return CPU����
	 */
	public Cpu createCpu();

	/**
	 * �����������
	 * 
	 * @return �������
	 */
	public MainBoard createMainBoard();
}