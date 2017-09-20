package com.java.string;

/**
 * 字符串操作
 * 
 * @author wangbo
 *
 */
public class StringOperation {
	public static void operation() {
		// 去掉字符串首尾空格
		String s = " wb ";
		s = s.trim();

		// 对于堆中的字符串对象，可以通过 intern()方法来将字符串添加的常量池中，并返回指向该常量的引用（常量池中无目标字符串）
		String str2 = new String("string");
		String str1 = "string";
		// 因为str1指向的是字符串中的常量，str2是在堆中生成的对象，所以str1==str2返回false
		System.out.println("str1 == str2 " + (str1 == str2));
		str2 = str2.intern();
		// str2调用intern方法，会将str2中值（“string”）复制到常量池中，但是常量池中已经存在该字符串（即str1指向的字符串），所以直接返回该字符串的引用，因此str1==str2返回true
		System.out.println("str1 == str2 " + (str1 == str2));

		// 通过字面量赋值创建字符串时，会优先在常量池中查找是否已经存在相同的字符串，倘若已经存在，栈中的引用直接指向该字符串；倘若不存在，则在常量池中生成一个字符串，再将栈中的引用指向该字符串
		String baseStr = "baseStr";
		final String baseFinalStr = "baseStr";

		String str3 = "baseStr01";
		String str4 = "baseStr" + "01";
		// str3 == str4返回true，因为str3和str4都指向常量池中的同一引用地址。其实在JAVA
		// 1.6之后，常量字符串的“+”操作，编译阶段直接会合成为一个字符串。
		System.out.println("str3 == str4 " + (str3 == str4));
		String str5 = baseStr + "01";
		// str5实际上是stringBuilder.append()生成的结果，所以与str3不相等，结果返回false
		System.out.println("str3 == str5 " + (str3 == str5));
		String str6 = baseFinalStr + "01";
		// 因为str3和str6指向的都是常量池中的第三项，所以str3==str6返回true。这里我们还能发现一个现象，对于final字段，编译期直接进行了常量替换，而对于非final字段则是在运行期进行赋值处理的
		System.out.println("str3 == str6 " + (str3 == str6));
		String str7 = new String("baseStr01").intern();
		System.out.println("str3 == str7 " + (str3 == str7));

		// 因为常量池中没有“str01”这个字符串，所以会在常量池中生成一个对堆中的“str01”的引用，而在进行字面量赋值的时候，常量池中已经存在，所以直接返回该引用即可，因此str8和str9都指向堆中的字符串，返回true
		String str8 = new String("str") + new String("01");
		str8.intern();
		String str9 = "str01";
		System.out.println("str8==str9 " + (str8 == str9));
		// 因为在进行字面量赋值（String str10 =
		// “str01″）的时候，常量池中不存在，所以str10指向的常量池中的位置，而str11指向的是堆中的对象，再进行intern方法时，对str10和str11已经没有影响了，所以返回false
		String str10 = "str01";
		String str11 = new String("str") + new String("01");
		str11.intern();
		System.out.println("str10==str11 " + (str10 == str11));
	}

}
