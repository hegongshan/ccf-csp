package com.hegongshan.ccfcsp.t2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 模板生成系统
 * 
 * @author hegongshan https://www.hegongshan.com
 */
public class T20150903 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 保存输入的数据
		int[] arr = toIntArray(scan.nextLine());
		int templateRows = arr[0];
		int varRows = arr[1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < templateRows; i++) {
			sb.append(scan.nextLine());
			if (i != templateRows - 1) {
				sb.append("\n");
			}
		}
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < varRows; i++) {
			String[] sArr = scan.nextLine().split(" \"");
			map.put(sArr[0], deleteQuote(sArr[1]));
		}
		scan.close();
		// 使用正则表达式替换模板变量
		Pattern p = Pattern.compile("\\{\\{\\s*\\w+\\s*}\\}");
		Matcher m = p.matcher(sb);
		StringBuffer sbuff = new StringBuffer();
		while (m.find()) {
			String var = m.group();
			String key = var.substring(2, var.length() - 2).trim();
			m.appendReplacement(sbuff, map.containsKey(key) ? map.get(key) : "");
		}
		m.appendTail(sbuff);
		System.out.println(sbuff);
	}

	// 根据空格切分字符串，并将其转换为整型数组
	private static int[] toIntArray(String str) {
		String[] temp = str.split(" ");
		int[] intArray = new int[temp.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(temp[i]);
		}
		return intArray;
	}

	// 删除首尾的引号
	private static String deleteQuote(String s) {
		if (s == null || s.trim().isEmpty()) {
			return "";
		}
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return s.substring(1, s.length() - 1);
		} else if (s.startsWith("\"")) {
			return s.substring(1);
		} else if (s.endsWith("\"")) {
			return s.substring(0, s.length() - 1);
		}
		return s;
	}
}
