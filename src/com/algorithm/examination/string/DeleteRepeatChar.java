package com.algorithm.examination.string;

import java.util.LinkedHashSet;
import java.util.Set;
/**
 * Ğ¯³Ì±ÊÊÔÖ®É¾³ı×Ö·û´®ÖĞÖØ¸´×Ö·û²¢Êä³ö
 * @author wangbo
 *
 */
public class DeleteRepeatChar {
	@SuppressWarnings("unchecked")
	public static void deleteReapteChar(String s){
		if(s==null||s.length()==0)
			return;
		@SuppressWarnings("rawtypes")
		Set<Character> set = new LinkedHashSet(); 
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			set.add(s.charAt(i));
		}
		for(Character c:set)
			sb.append(c);
		System.out.println(sb.toString());
	}
}
