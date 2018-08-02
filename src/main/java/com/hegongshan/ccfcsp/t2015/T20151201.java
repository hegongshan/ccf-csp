package com.hegongshan.ccfcsp.t2015;

import java.util.Scanner;

/**
 * 数位之和
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class T20151201 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		scan.close();
		String str = Integer.toString(data);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		System.out.println(sum);
	}
}
