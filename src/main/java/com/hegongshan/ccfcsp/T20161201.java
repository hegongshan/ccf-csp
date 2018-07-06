package com.hegongshan.ccfcsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T20161201 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> dataList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dataList.add(scan.nextInt());
		}
		scan.close();
		int leftNum = 0,rightNum = 0;
		boolean flag = false;
		int medium = 0;
		for (int i = 0; i < dataList.size(); i++) {
			for (int k = 0; k < dataList.size(); k++) {
				if(i == k) {
					continue;
				}
				if(dataList.get(i) < dataList.get(k)) {
					rightNum++;
				} else if(dataList.get(i) > dataList.get(k)) {
					leftNum++;
				}
			}
			if(leftNum == rightNum) {
				flag = true;
				medium = dataList.get(i);
			} else {
				leftNum = rightNum = 0;
			}
		}
		if(flag) {
			System.out.println(medium);
		} else {
			System.out.println(-1);
		}
	}
}
