package com.designpattern.factory.simple;

public class DomainLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		/**
		 * ����ҵ���߼�
		 */
		return true;
	}

}
