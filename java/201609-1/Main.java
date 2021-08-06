import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] prices = new int[total];
		for (int i = 0; i < total; i++) {
			prices[i] = scan.nextInt();
		}
		scan.close();
		int max = 0,temp;
		for (int i = 1; i < prices.length; i++) {
			temp = Math.abs(prices[i]-prices[i-1]);
			if(max < temp) {
				max = temp;
			}
		}
		System.out.println(max);
	}
}
