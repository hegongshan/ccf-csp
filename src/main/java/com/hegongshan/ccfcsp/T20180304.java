package com.hegongshan.ccfcsp;

import java.util.Scanner;

public class T20180304 {

	public static void main(String[] args) {
		// 1.获取输入条件
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] score = new int[total];
		int[][][] data = new int[total][3][3];
		for (int i = 0; i < total; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					data[i][j][k] = scan.nextInt();
				}
			}
		}
		scan.close();

		// 2.处理
		for (int i = 0; i < score.length ; i++) {
			score[i] = dfs(data,i,People.X);
		}

		// 3.打印评分
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
	}
	
	private static int getZeroCount(int[][][] data, int i) {
		int count = 0;
		for (int j = 0; j < data[i].length; j++) {
			for (int k = 0; k < data[i][j].length; k++) {
				if (data[i][j][k] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	private static int dfs(int[][][] data, int i,People people) {
		if(getZeroCount(data,i) == 9) {//棋盘为空
			return 0;
		}
		if(isWin(data,i)) {//已经赢了
			return score(data,i);
		}
		for (int j = 0; j < data[i].length; j++) {
			for (int k = 0; k < data[i][j].length; k++) {
				if (data[i][j][k] == 0) {
					data[i][j][k] = people.getValue();
					//下一子，如果赢了，则返回评分，否则，换人继续下子
					if(isWin(data,i)) {
						return score(data,i);
					} else {
						if(people == People.X) {
							max = Math.max(max, dfs(data,i,People.O));
						} else {
							min = Math.min(min, dfs(data,i,People.X));
						}
						data[i][j][k] = 0;
					}
				}
			}
		}
		return people == People.X ? max : min;
	}
	
	private static boolean isWin(int[][][] data, int i) {
		if (data[i][1][1] != 0 && (
				(data[i][0][0] == data[i][1][1] && data[i][0][0] == data[i][2][2]) || 
				(data[i][0][2] == data[i][1][1] && data[i][2][0] == data[i][1][1]))) {
			return true;
		}

		for (int j = 0; j < 3; j++) {
			// 一行(列)三子相同
			if ((data[i][j][0] == data[i][j][1] && data[i][j][0] == data[i][j][2] && data[i][j][0] != 0) ||
					(data[i][0][j] == data[i][1][j] && data[i][0][j] == data[i][2][j] && data[i][0][j] != 0)) {
				return true;
			}
		}
		
		return false;
	}
	
	static int score(int[][][] data, int i) {
		if (data[i][1][1] == 2 && (
				(data[i][0][0] == 2 && data[i][2][2] == 2) || 
				(data[i][0][2] == 2 && data[i][2][0] == 2))) {
			return -(getZeroCount(data, i) + 1);
		}
		
		if (data[i][1][1] == 1 && (
				(data[i][0][0] == 1 && data[i][2][2] == 1) || 
				(data[i][0][2] == 1 && data[i][2][0] == 1))) {
			return getZeroCount(data, i) + 1;
		}

		for (int j = 0; j < 3; j++) {
			// 一行(列)三子相同
			if ((data[i][j][0] == 2 && data[i][j][1] == 2 && data[i][j][2] == 2) ||
				(data[i][0][j] == 2 && data[i][1][j] == 2 && data[i][2][j] == 2)) {
				return -(getZeroCount(data, i) + 1);
			}
			if ((data[i][j][0] == 1 && data[i][j][1] == 1 && data[i][j][2] == 1) ||
					(data[i][0][j] == 1 && data[i][1][j] == 1 && data[i][2][j] == 1)) {
					return getZeroCount(data, i) + 1;
				}
		}
		return 0;
	}
	
	static int max = 10;
	static int min = -10;
	enum People {
		X(1),O(2);
		int value;
		private People(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
}