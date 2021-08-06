import java.util.Scanner;
/**
 * 小明上学
 * @author hegongshan
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int y = scan.nextInt();
		int g = scan.nextInt();
		int n = scan.nextInt();
		int[][] arr = new int[n][2];
		int time = 0;
		for (int i = 0; i < n; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
			if (arr[i][0] == 0 || arr[i][0] == 1) {
				time += arr[i][1];
			} else if (arr[i][0] == 2) {
				time += arr[i][1] + r;
			}
		}
		scan.close();

		System.out.println(time);
	}
}
