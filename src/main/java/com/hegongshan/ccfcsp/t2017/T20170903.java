package com.hegongshan.ccfcsp.t2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class T20170903 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int line = scan.nextInt();
		int count = Integer.parseInt(scan.nextLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line ; i++) {
			sb.append(scan.nextLine());
		}
		List<String> list = new ArrayList<>(count);
		System.out.println(count);
		for (int i = 0; i < count ; i++) {
			list.add(scan.nextLine().trim());
		}
		scan.close();
		String json = sb.toString();
		JSONObject jsonObj = new JSONObject().fromString(json);
		for(String s : list) {
			if(!s.contains(".")) {
				Object obj = jsonObj.getValue(s);
				if(obj instanceof String) {
					System.out.println("STRING "+obj);
				} else if(obj instanceof JSONObject) {
					System.out.println("OBJECT");
				} else {
					System.out.println("NOTEXIST");
				}
			} else {
				String[] sArr = s.split(".");
				Object obj;
				for (int i = 0; i < sArr.length; i++) {
					obj = jsonObj.getValue(sArr[i]);
					if(obj instanceof String) {
						System.out.println("STRING "+obj);
						break;
					} else if(obj instanceof JSONObject) {
						continue;
					} else {
						System.out.println("NOTEXIST");
						break;
					}
				}
			}
		}
	}
	
	static class JSONObject {
		private Map<String,Object> map = new HashMap<>();
		
		JSONObject fromString(String str) {
			String[] keyAndValues = delte(str).split(",");
			for (int i = 0; i < keyAndValues.length; i++) {
				System.out.println(keyAndValues[i]);
				String[] kv = keyAndValues[i].split(":");
				String key = delete0(kv[0]);
				System.out.println("key:"+key);
				String value = delete0(kv[1]);
				System.out.println("value:"+value);
				if(!isJSON(value)) {
					map.put(key,value);
				} else {
					JSONObject jsonObj = fromString(value);
					map.put(key, jsonObj);
					System.out.println(jsonObj);
				}
			}
			return this;
			
		}
		
		boolean isJSON(String str) {
			str = str.trim();
			if(!str.startsWith("{") || !str.endsWith("}")) {
				return false;
			}
			Stack<Character> stack = new Stack<>();
			char[] charArr = str.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				if(charArr[i] == '{') {
					stack.push('{');
				} else if(charArr[i] == '}') {
					if(stack.peek()=='{') {
						stack.pop();
					} else {
						return false;
					}
				}	
			}
			return true;
		}
		
		Object getValue(String key) {
			return map.get(key);
		}
		
		private String delte(String str) {
			str = str.trim();
			if(str.startsWith("{")) {
				str = str.substring(1);
			}
			if(str.endsWith("}")) {
				str = str.substring(0,str.length()-1);
			}
			return str;
		}
		
		private String delete0(String str) {
			str = str.trim();
			if(str.startsWith("\"")) {
				str = str.substring(1);
			}
			if(str.endsWith("\"")) {
				str = str.substring(0,str.length()-1);
			}
			return str;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("{");
			map.forEach((k,v)->{
				sb.append("\""+k+"\""+":"+"\""+v+"\"");	
			});
			sb.append("}");
			return sb.toString();
		}
	}
	
}
