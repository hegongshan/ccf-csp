package com.hegongshan.ccfcsp.t2015;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 节日
 * @author hegongshan　https://www.hegongshan.com
 *
 */
public class T20150303 {
	private static final int[] MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		int week = scan.nextInt();
		int dayOfWeek = scan.nextInt();
		int startYear = scan.nextInt();
		int endYear = scan.nextInt();
		scan.close();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for (int i = startYear; i <= endYear; i++) {
			StringBuilder sb = new StringBuilder(i);
			/*sb.append(addZero(week)).append(addZero(day));
			calendar.setTime(sdf.parse(source));*/
		}
	}
	
	public static String addZero(int time) {
		return time < 10 ? 0+""+time : String.valueOf(time);
	}
	
	/*public static Date toDate(int year,int month,int week,int dayOfWeek) {
		int[] months = Arrays.copyOf(MONTHS,MONTHS.length);
		if(isLeapYear(year)) {
			months[1] += 1;
		}
		int sum = 0;
		for (int i = 0; i < month; i++) {
			sum += months[i];
		}
		for (int i = 1850; i < year; i++) {
			int[] months2 = Arrays.copyOf(MONTHS, MONTHS.length);
			if(isLeapYear(year)) {
				months2[1] += 1;
			}
			sum += sum(months);
		}
	}*/
	
	public static boolean isLeapYear(int year) {
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
