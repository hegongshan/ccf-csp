package com.hegongshan.ccfcsp.t2015;

import java.util.Scanner;

/**
 * 图像旋转
 * 
 * @author hegongshan
 *
 */
public class T20150301 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int column = Integer.parseInt(scan.nextLine().trim());
		int[][] arr = new int[row][column];
		for (int i = 0; i < arr.length; i++) {
			String[] sArr = scan.nextLine().split(" ");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(sArr[j]);
			}
		}
		scan.close();

		// 原来的行变为现在的列，且元素倒排
		int index = column;
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(arr[j][index - 1] + " ");
			}
			index--;
			System.out.println();
		}
	}
}
