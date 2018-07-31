package com.hegongshan.ccfcsp.t2013;

import java.util.Scanner;

/**
 * ISBN号码
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class T20131202 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String isbn = scan.nextLine();
		String isbnWithoutLine = isbn.replace("-", "");
		scan.close();
		
		char[] arr = isbnWithoutLine.toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			sum += Character.getNumericValue(arr[i]) * (i+1);
		}
		int id = sum % 11;
		char identityCode = id < 10 ? Character.forDigit(id, 10) : 'X';
		if(identityCode == arr[arr.length-1]) {
			System.out.println("Right");
		} else {
			System.out.println(isbn.substring(0, isbn.length()-1)+identityCode);
		}
	}
}
