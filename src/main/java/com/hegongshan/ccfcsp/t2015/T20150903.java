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
		int templateRows = scan.nextInt();
		int varRows = Integer.parseInt(scan.nextLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < templateRows; i++) {
			sb.append(scan.nextLine());
			if (i != templateRows - 1) {
				sb.append("\n");
			}
		}
		Map<String, String> map = new HashMap<>();
		int index;
		for (int i = 0; i < varRows; i++) {
			String keyValue = scan.nextLine();
			index = keyValue.indexOf(" ");
			String key = keyValue.substring(0,index);
			//从第一个空格之后截取，并去掉首尾的双引号
			String value = keyValue.substring(index+2,keyValue.length()-1);
			map.put(key,value);
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
}
