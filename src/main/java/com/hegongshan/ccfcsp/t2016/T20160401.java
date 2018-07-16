package com.hegongshan.ccfcsp.t2016;

import java.util.Scanner;

public class T20160401 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[][] data = new int[total][3];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = scan.nextInt();
			if(i==0) {
				data[i][1] = 0;
			} else {
				data[i-1][2] = data[i][0] - data[i-1][0];
				data[i][1] = data[i-1][2];
			}
			if(i == total - 1) {
				data[i][2] = 0;
			}
		}
		scan.close();
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if((data[i][1] > 0 && data[i][2] < 0) ||
					(data[i][1] < 0 && data[i][2] > 0)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
