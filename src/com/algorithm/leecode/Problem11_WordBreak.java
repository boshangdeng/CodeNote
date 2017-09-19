package com.algorithm.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/**
 * 给一字符串s="catsanddog",摘要dict=["cat", "cats", "and", "sand", "dog"],组成方法有solution:["cats and dog", "cat sand dog"]
 * @author wangbo
 * Created on 2017年9月2日 下午5:46:54
 */
public class Problem11_WordBreak {
	 public static ArrayList<String> wordBreak(String s,Set<String> dict){
		 ArrayList<String> list=new ArrayList<String>();
		 if(s==null||s.length()==0)
			 return list;
		 HashMap<String,List<String>> map=new HashMap<String,List<String>>();
		 list=dfs(s,dict,map);
		 return list;
	 }
	
	/**
	 * @param s
	 * @param dict
	 * @param map
	 * @return
	 */
	public static ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
		if(map.containsKey(s))
			return (ArrayList<String>) map.get(s);
		//记录每一阶段的所有状态
		ArrayList<String> list=new ArrayList<String>();
		if(s.equals(""))
			list.add("");
		else{
			int len=s.length();
			for(int i=len-1;i>=0;i--){
				String sub=s.substring(i,len);
				if(dict.contains(sub)){
					ArrayList<String> t=dfs(s.substring(0, i),dict,map);
					if(t.size()==0){
						continue;
					}else{
						for(int j=0;j<t.size();j++){
							StringBuilder sb=new StringBuilder();
							sb.append(t.get(j)).append(" ").append(sub);
							list.add(sb.toString().trim());
						}
					}
				}
			}
		}
		map.put(s, list);
		return list;
	}
}
