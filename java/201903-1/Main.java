import java.util.Scanner;

/**
 * 小中大 http://118.190.20.162/view.page?gpid=T89
 * @author hegongshan
 * @date 2021-10-05
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();

		int min = Math.min(arr[0], arr[n - 1]);
		int max = Math.max(arr[0], arr[n - 1]);

		System.out.printf("%d ", max);
		float mid;
		int midIdx = n >> 1;
		if ((n & 0x1) == 1) {
			mid = arr[midIdx];
		} else {
			mid = (arr[midIdx - 1] + arr[midIdx]) / 2.0f;
		}
		if (mid == (int)mid) {
			System.out.printf("%d ", (int)mid);
		} else {
			System.out.printf("%.1f ", mid);
		}
		System.out.println(min);
	}
}