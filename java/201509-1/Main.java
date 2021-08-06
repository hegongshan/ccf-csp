import java.util.Scanner;

/**
 * 数列分段
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] arr = new int[total];
		int count = total;
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = scan.nextInt();
			if(i > 0 && arr[i] == arr[i-1]) {
				count--;
			}
		}
		scan.close();
		System.out.println(count);
		
	}
}
