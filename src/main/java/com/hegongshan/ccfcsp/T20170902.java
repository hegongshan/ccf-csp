package com.hegongshan.ccfcsp;

import java.util.Scanner;

public class T20170902 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] sequence = new int[n];
		for (int i = 0; i < sequence.length ; i++) {
			sequence[i] = i+1;
		}
		int k = scan.nextInt();
		int[][] data = new int[k][3];
		for (int i = 0; i < k; i++) {
			data[i][0] = scan.nextInt();
			data[i][1] = scan.nextInt();
			data[i][2] = data[i][1] + scan.nextInt();
		}
		scan.close();
		
		sort(data,1);
		
		int start = data[0][1];
		sequence[start] = 0;
		
		for (int i = 0; i < data.length; i++) {
			sequence[data[i][1]] = 0;
		}
		
		for (int i = 0; i < sequence.length ; i++) {
			System.out.print(sequence[i]+" ");
		}
		
	}
	
	static int[][] sort(int[][] data,int index) {
		int temp;
		for (int i = 0; i < data.length; i++) {
			for (int j = data.length - 1; j > i; j--) {
				if(data[j][index] < data[j-1][index]) {
					temp = data[j][0];
					data[j][0] = data[j-1][0];
					data[j-1][0] = temp;

					temp = data[j][1];
					data[j][1] = data[j-1][1];
					data[j-1][1] = temp;
					
					temp = data[j][2];
					data[j][2] = data[j-1][2];
					data[j-1][2] = temp;
				}
			}
		}
		return data;
	}
}
