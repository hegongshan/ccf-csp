package com.hegongshan.ccfcsp.t2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T20170302 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = scan.nextInt();
		List<Integer> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(i+1);
		}
		for (int i = 0; i < count; i++) {
			int id = scan.nextInt();
			int move = scan.nextInt();
			int index = list.indexOf(id);
			list.remove(index);
			if(move > 0) {
				list.add(index+move, id);
			} else {
				move = Math.abs(move);
				list.add(index-move,id);
			}
		}
		scan.close();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
