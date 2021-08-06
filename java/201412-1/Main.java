import java.util.Scanner;

/**
 * 门禁系统
 * 
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[][] arr = new int[total][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = scan.nextInt();
		}
		scan.close();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j >= 0; j--) {
				if (arr[i][0] == arr[j][0]) {
					arr[i][1]++;
				}
			}
			System.out.print(arr[i][1] + " ");
		}

	}
}
