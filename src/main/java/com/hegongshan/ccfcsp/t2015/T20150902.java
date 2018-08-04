package com.hegongshan.ccfcsp.t2015;

import java.util.Scanner;

/**
 * 日期计算
 * 
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class T20150902 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		int day = scan.nextInt();
		scan.close();

		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeap(year)) {
			months[1] = 29;
		}
		int sum = 0;
		int i = 0;
		while (sum < day) {
			sum += months[i++];
		}
		System.out.println(i);
		System.out.println(day - (sum - months[i - 1]));
	}

	public static boolean isLeap(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		}
		return false;
	}
}
