package com.hegongshan.ccfcsp;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class T20171202 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int k = scan.nextInt();
		scan.close();
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < total ; i++) {
			queue.add(i+1);
		}
		int currentNumber = 0;
		while(queue.size() > 1) {
			currentNumber++;
			if(currentNumber % k == 0 || currentNumber % 10 == k) {
				queue.poll();
			} else {
				queue.add(queue.poll());
			}
		}
		System.out.println(queue.peek());
	}
}
