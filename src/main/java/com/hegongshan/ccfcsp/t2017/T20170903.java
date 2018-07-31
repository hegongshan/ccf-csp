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
		int count = scan.nextInt();
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
			/*if(!json.contains(s)) {
				System.out.println("NOTEXIST");
			} else {
				if(json.charAt(json.indexOf("\""+s+"\"")+("\""+s+"\"").length()+2) == '{') {
					System.out.println("OBJECT");
				} else {
					String[] keyAndValues = json.split(",");
					for (int i = 0; i < keyAndValues.length; i++) {
						String key = keyAndValues[i].split(":")[0];
						String value = keyAndValues[i].split(":")[1];
						if(key.substring(1,key.length()-1).equals(s)) {
							System.out.println("STRING "+value.substring(1,value.length()-1));
							break;
						}
					}
				}
			}*/
		}
	}
	
	static class JSONObject {
		private Map<String,Object> map = new HashMap<>();
		
		JSONObject fromString(String str) {
			String[] keyAndValues = str.trim().split(",");
			for (int i = 0; i < keyAndValues.length; i++) {
				String[] kv = keyAndValues[i].split(":");
				String key = kv[0].trim().substring(1, kv[0].trim().length()-1);
				System.out.println(kv[1]);
				String value = kv[1].trim().startsWith("{") ? kv[1].trim() : kv[1].trim().substring(1,kv[1].trim().length()-1);
				if(!isJSON(value)) {
					map.put(key,value);
				} else {
					map.put(key, fromString(value));
				}
			}
			return this;
			
		}
		
		boolean isJSON(String str) {
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
	}
	
}
