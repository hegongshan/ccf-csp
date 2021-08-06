import java.util.Scanner;
/**
 * 卖菜
 * @author hegongshan
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();

		int[] out = new int[n];
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < out.length; i++) {
			if (i == 0) {
				out[i] = (arr[i] + arr[i + 1]) / 2;
			} else if (i == n - 1) {
				out[i] = (arr[i - 1] + arr[i]) / 2;
			} else {
				out[i] = (arr[i - 1] + arr[i] + arr[i + 1]) / 3;
			}
			sb.append(out[i]).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
}
