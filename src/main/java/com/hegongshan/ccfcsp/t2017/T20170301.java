package com.hegongshan.ccfcsp.t2017;

import java.util.Scanner;

public class T20170301 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] cakes = new int[n];
		for (int i = 0; i < n; i++) {
			cakes[i] = scan.nextInt();
		}
		scan.close();
		
		int sum = 0;
		int totalPerson = 0;
		for (int i = 0; i < cakes.length; i++) {
			sum += cakes[i];
			if(sum >= k) {
				sum = 0;
				totalPerson++;
			} else if(sum < k && i == cakes.length -1) {
				totalPerson++;
			}
		}
		System.out.println(totalPerson);
	}
}
