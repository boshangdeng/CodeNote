package com.java.generics;

import java.util.ArrayList;

class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}

/**
 * PECS原则： 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
 * 
 * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
 * 
 * 如果既要存又要取，那么就不要使用任何通配符。
 * 
 * @author wangbo
 *
 * @param <T>
 */
public class TestLastNextBorder<T> {
	public static void main(String[] args) {
		// List< ? extends Fruit>
		// 可以解读为，“具有任何从Fruit继承的类型”，但实际上，它意味着，它没有指定具体类型。对于编译器来说，当你指定了一个 List< ?
		// extends Fruit>，add 的参数也变成了“? extends Fruit”。因此编译器并不能了解这里到底需要哪种 Fruit
		// 的子类型，因此他不会接受任何类型的 Fruit。
		ArrayList<? extends Fruit> list = new ArrayList<>();
		// 指定上届，不能添加任何类型，除了null,因为null代表任何类型
		// list.add(new Apple()); //报错
		// list.add(new Orange()); //报错
		// list.add(new Fruit()); //报错
		list.add(null);
		// contain 和 indexof 却能执行，这是因为，这两个方法的参数是 Object，不涉及任何的通配符
		list.contains(new Apple());
		list.indexOf(new Apple());

		Fruit apple = list.get(0);
		// List< ? super Apple> 表示“具有Apple的父类的列表”,但是为什么 add(new Fruit())不能成功
		// 呢？正是因为？代表Apple的父类，但是编译器不知道你要添加哪种Apple的父类，因此不能安全地添加。
		ArrayList<? super Apple> list1 = new ArrayList<>();
		list1.add(new Apple());
		// list1.add(new Fruit()); //报错
		// 编译器不确定列表中的Apple
		Object object = list1.get(0);
	}

}
