import java.util.Scanner;

/**
 * Z字形扫描
 * 
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		// 1.输入数据
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();

		// 2.按照→ ↙ ↓ ↗顺序，判断下一步往何处走
		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder(n * n);
		boolean isRight = true, isLeftDown = false, isDown = false, isRightUp = false;
		while (i < n && j < n) {
			if (isRight) {
				// 2.1向右走
				isRight = false;
				sb.append(arr[i][j++]).append(" ");
				// 若达到下边界，则往右上走，否则默认往左下走
				if (i == n - 1) {
					isRightUp = true;
				} else {
					isLeftDown = true;
				}
			} else if (isLeftDown) {
				// 2.2先向左下走，直到走到左边界和下边界为止
				if (i < n - 1 && j > 0) {
					sb.append(arr[i++][j--]).append(" ");
				} else {
					isLeftDown = false;
					isDown = true;
				}
			} else if (isDown) {
				isDown = false;
				// 2.3向下走，若达到下边界，则向右走
				if (i == n - 1) {
					isRight = true;
				} else {
					sb.append(arr[i++][j]).append(" ");
					// 若达到右边界，则往左下走，否则默认往右上走
					if (j < n - 1) {
						isRightUp = true;
					} else {
						isLeftDown = true;
					}
				}
			} else if (isRightUp) {
				// 2.4向右上走，若达到上边界，往右走；若达到右边界，则往下走
				if (i > 0 && j < n - 1) {
					sb.append(arr[i--][j++]).append(" ");
				} else {
					isRightUp = false;
					if (i == 0 && j != n - 1) {
						isRight = true;
					} else if (j == n - 1) {
						isDown = true;
					}
				}
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}
}
