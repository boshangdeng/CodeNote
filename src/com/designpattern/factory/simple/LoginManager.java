package com.designpattern.factory.simple;

public class LoginManager {
	public static Login factory(String type) {
		if (type.equals("password")) {
			return new PassWordLogin();
		} else if (type.equals("domain")) {
			return new DomainLogin();
		} else {
			throw new RuntimeException("û���ҵ���¼����");
		}
	}
}
