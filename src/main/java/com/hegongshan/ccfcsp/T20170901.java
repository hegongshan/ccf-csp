package com.hegongshan.ccfcsp;

import java.util.Scanner;

public class T20170901 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		scan.close();

		int total = 0;
		if (money < 30) {// 小于30块
			total = money / 10;
		} else if (money >= 30 && money < 50) {// 大于30但是小于50块
			total = (money - 30) / 10 + (30 / 10 + 1);
		} else {// 大于50块
			int numFor5 = money / 50;// 可连续买5瓶的数量
			int i = money - numFor5 * 50;// 剩下的钱
			int numFor3 = 0, num = 0;
			if (i >= 30) {// 如果剩下的钱大于30块,先参加买三送一，剩下的钱单买
				numFor3 = i / 30;
				num = (i - numFor3*30) / 10;
			} else {
				num = i / 10;
			}
			total = numFor5 * (5 + 2) + numFor3 * (3 + 1) + num;
		}
		System.out.println(total);
	}
}
