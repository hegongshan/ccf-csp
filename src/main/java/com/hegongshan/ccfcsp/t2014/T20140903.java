package com.hegongshan.ccfcsp.t2014;

import java.util.Scanner;

/**
 * 字符串匹配
 * @author hegongshan　https://www.hegongshan.com
 *
 */
public class T20140903 {
	public static void main(String[] args) {
		//------------输入开始----------------------
		Scanner scan = new Scanner(System.in);
		String pattern = scan.nextLine();
		boolean ignoreCase = Integer.parseInt(scan.nextLine().trim()) == 0 ? true : false; 
		int count = Integer.parseInt(scan.nextLine().trim());
		String[] sArr = new String[count];
		for (int i = 0; i < sArr.length ; i++) {
			sArr[i] = scan.nextLine();
		}
		scan.close();
		//------------输入结束-----------------------
		for (int i = 0; i < sArr.length; i++) {
			boolean containsIgnoreCase = ignoreCase && sArr[i].toLowerCase().contains(pattern.toLowerCase());
			boolean contains = !ignoreCase && sArr[i].contains(pattern);
			if(containsIgnoreCase || contains) {
				System.out.println(sArr[i]);
			}
		}
	}
}
