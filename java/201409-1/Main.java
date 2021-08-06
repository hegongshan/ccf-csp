import java.util.Scanner;

/**
 * 相邻数对
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		// 1. 获得输入数据
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] arr = new int[total];
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		//　2. 遍历数组arr，记录相差1的数对的个数
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(Math.abs(arr[i]-arr[j]) == 1) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}
}
