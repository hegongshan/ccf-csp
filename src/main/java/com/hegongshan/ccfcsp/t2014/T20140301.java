package com.hegongshan.ccfcsp.t2014;

import java.util.Scanner;

/**
 * 相反数
 * @author hegongshan https://www.hegongshan.com <br>
 */
public class T20140301 {
	public static void main(String[] args) {
		// 1. 获得输入数据
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] dataArr = new int[total];
		for (int i = 0; i < total ; i++) {
			dataArr[i] = scan.nextInt();
		}
		scan.close();
		
		//　2. 遍历数组dataArr，记录相反数的对数
		int count = 0;//相反数的对数
		for (int i = 0; i < dataArr.length; i++) {
			for (int j = i + 1; j < dataArr.length; j++) {
				if(dataArr[i] == -dataArr[j]) {
					count ++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
