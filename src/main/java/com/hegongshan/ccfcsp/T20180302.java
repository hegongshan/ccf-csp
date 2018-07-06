package com.hegongshan.ccfcsp;

import java.util.Scanner;

public class T20180302 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] condition = toIntArray(scan.nextLine().split(" "));
		int[] data = toIntArray(scan.nextLine().split(" "));
		
		int[] lastPosition = new int[data.length];
		int line = condition[1];
		int t = condition[2];
		int[] directions = new int[data.length];
		for (int i = 0; i < directions.length; i++) {
			directions[i] = 1;//默认向右移动
		}
		// 执行t次
		for (int i = 0; i < t; i++) {
			// 上一次小球的位置
			for (int j = 0; j < lastPosition.length; j++) {
				lastPosition[j] = data[j];
			}
			for (int j = 0; j < lastPosition.length; j++) {
				if (lastPosition[j] == line || lastPosition[j] == 0) {
					directions[j] = -directions[j];
				} else {
					for (int k = 0; k < lastPosition.length; k++) {
						if(j != k && lastPosition[j] == lastPosition[k]) {
							directions[j] = -directions[j];
							break;
						}
					}
				}
				data[j] += directions[j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(data[i] + " ");
		}
		System.out.println(sb.toString());
		scan.close();
	}

	private static int[] toIntArray(String[] sArr) {
		int[] intArr = new int[sArr.length];
		for (int i = 0; i < sArr.length; i++) {
			intArr[i] = Integer.valueOf(sArr[i]);
		}
		return intArr;
	}
}
