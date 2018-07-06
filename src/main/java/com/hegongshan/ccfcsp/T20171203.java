package com.hegongshan.ccfcsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class T20171203 {
	
	private static SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMddHHmm");
	private static Calendar calendar = new GregorianCalendar();
	static int computeDayOfWeek(long time) throws ParseException {
		calendar.setTime(sdf.parse(String.valueOf(time)));
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek - 1;
	}
	
	public static void main(String[] args) throws ParseException {
		//long start = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		
		String[] strArr = scan.nextLine().split(" ");
		int total = Integer.parseInt(strArr[0]);
		long startTime = Long.parseLong(strArr[1]);
		long endTime = Long.parseLong(strArr[2]);
		for (int i = 0; i < total ; i++) {
			String[] configs = scan.nextLine().split(" ");
			Config config = new Config();
		}

		scan.close();
	}
	static class Config {
		private String minute;
		private String hour;
		private String dayOfMonth;
		private String month;
		private String command;
	}
	enum Month {
		Jan("Jan",1),Feb("Feb",2),Mar("Mar",3),Apr("Apr",4),May("May",5),
		Jun("Jun",6),Jul("Jul",7),Aug("Aug",8),Sep("Sep",9),Oct("Oct",10),
		Nov("Nov",11),Dec("Dec",12);
		String name;
		int value;
		private Month(String name,int value) {
			this.name = name;
			this.value = value;
		}
	}
	enum Week {
		Sun("Sun",0),Mon("Mon",1),Tue("Tue",2),Wed("Wed",3),Thu("Thu",4),Fri("Fri",5),Sat("Sat",6);
		String name;
		int value;
		private Week(String name,int value) {
			this.name = name;
			this.value = value;
		}
	}
	
	static int getDayOfWeek(String s) {
		for(Week week : Week.values()) {
			if(s.equalsIgnoreCase(week.name) || s.equals(String.valueOf(week.value))) {
				return week.value;
			} 
		}
		return -1;
	}
	
	static int getMonth(String s) {
		for(Month month : Month.values()) {
			if(s.equalsIgnoreCase(month.name) || s.equals(String.valueOf(month.value))) {
				return month.value;
			} 
		}
		return -1;
	}
}
