package com.java.generics;

import java.util.ArrayList;

class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}

/**
 * PECSԭ�� ���Ҫ�Ӽ����ж�ȡ����T�����ݣ����Ҳ���д�룬����ʹ�� ? extends ͨ�����(Producer Extends)
 * 
 * ���Ҫ�Ӽ�����д������T�����ݣ����Ҳ���Ҫ��ȡ������ʹ�� ? super ͨ�����(Consumer Super)
 * 
 * �����Ҫ����Ҫȡ����ô�Ͳ�Ҫʹ���κ�ͨ�����
 * 
 * @author wangbo
 *
 * @param <T>
 */
public class TestLastNextBorder<T> {
	public static void main(String[] args) {
		// List< ? extends Fruit>
		// ���Խ��Ϊ���������κδ�Fruit�̳е����͡�����ʵ���ϣ�����ζ�ţ���û��ָ���������͡����ڱ�������˵������ָ����һ�� List< ?
		// extends Fruit>��add �Ĳ���Ҳ����ˡ�? extends Fruit������˱������������˽����ﵽ����Ҫ���� Fruit
		// �������ͣ��������������κ����͵� Fruit��
		ArrayList<? extends Fruit> list = new ArrayList<>();
		// ָ���Ͻ죬��������κ����ͣ�����null,��Ϊnull�����κ�����
		// list.add(new Apple()); //����
		// list.add(new Orange()); //����
		// list.add(new Fruit()); //����
		list.add(null);
		// contain �� indexof ȴ��ִ�У�������Ϊ�������������Ĳ����� Object�����漰�κε�ͨ���
		list.contains(new Apple());
		list.indexOf(new Apple());

		Fruit apple = list.get(0);
		// List< ? super Apple> ��ʾ������Apple�ĸ�����б�,����Ϊʲô add(new Fruit())���ܳɹ�
		// �أ�������Ϊ������Apple�ĸ��࣬���Ǳ�������֪����Ҫ�������Apple�ĸ��࣬��˲��ܰ�ȫ����ӡ�
		ArrayList<? super Apple> list1 = new ArrayList<>();
		list1.add(new Apple());
		// list1.add(new Fruit()); //����
		// ��������ȷ���б��е�Apple
		Object object = list1.get(0);
	}

}
