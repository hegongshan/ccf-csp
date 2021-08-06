import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int l = scan.nextInt();
		int t = scan.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		// 默认向右移动
		int[] directions = new int[n];
		Arrays.fill(directions, 1);

		int[] lastPos = new int[n];
		// 执行t次
		for (int i = 0; i < t; i++) {
			lastPos = Arrays.copyOf(arr, arr.length);
			for (int j = 0; j < lastPos.length; j++) {
				// 若小球位于左端点，且不是初始时刻，则需要改变方向
				if (lastPos[j] == 0) {
					if (i > 0) {
						directions[j] = -directions[j];
					}
				} else if (lastPos[j] == l) {
					// 若小球位于右端点，则需要改变方向
					directions[j] = -directions[j];
				} else {
					// 否则，判断是否发生了碰撞
					for (int k = 0; k < lastPos.length; k++) {
						// 若发生了碰撞，则需要改变方向
						if (j != k && lastPos[j] == lastPos[k]) {
							directions[j] = -directions[j];
							break;
						}
					}
				}
				arr[j] += directions[j];
			}
		}
		scan.close();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(' ');
			}
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}

}
