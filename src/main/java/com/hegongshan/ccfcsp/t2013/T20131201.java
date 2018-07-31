package com.hegongshan.ccfcsp.t2013;

import java.util.Scanner;

/**
 * 出现次数最多的数
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class T20131201 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int size = 0;
		int num;
		int[][] arr = new int[total][2];
		for (int i = 0; i < arr.length ; i++) {
			num = scan.nextInt();
			boolean flag = false;
			for (int j = 0; j < size; j++) {
				if(arr[j][0] == num) {
					arr[j][1] += 1;
					flag = true;
					break;
				}
			}
			if(!flag) {
				//数字
				arr[i][0] = num;
				//出现次数
				arr[i][1] = 1;
				size++;
			}
		}
		scan.close();
		
		int max = 0;
		int data = 0;
		//选出出现次数最多的数。如果这样的数有多个，输出其中最小的一个
		for (int i = 0; i < size; i++) {
			if(arr[i][1] > max) {
				max = arr[i][1];
				data = arr[i][0];
			} else if(arr[i][1] == max && arr[i][0] < data) {
				data = arr[i][0];
			}
		}
		System.out.println(data);
	}
}
