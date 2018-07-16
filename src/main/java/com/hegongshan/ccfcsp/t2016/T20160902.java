package com.hegongshan.ccfcsp.t2016;

import java.util.Scanner;

public class T20160902 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		//初始化座位信息
		int[][] tickets = new int[20][5];
		for (int i = 0; i < tickets.length; i++) {
			for (int j = 0; j < tickets[i].length; j++) {
				tickets[i][j] = 0;
			}
		}
		for (int i = 0; i < total; i++) {
			int num = scan.nextInt();
			int count = 0;
			outerLoop:for (int j = 0; j < tickets.length; j++) {
				for (int k = 0; k < tickets[j].length; k++) {
					if(tickets[j][k] == 0) {
						count++;
						if(count==num) {
							int id = j*5+k+1;
							for (int m = id-num+1; m <= id; m++) {
								System.out.print(m+" ");
								tickets[j][m%5] = 1;
							}
							System.out.println();
							break outerLoop;
						}
					} else {
						count = 0;
					}
				}
				count = 0;
			}
		}
		scan.close();
	}
}
