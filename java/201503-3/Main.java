import java.util.Scanner;

public class Main {
	public static int[][] MONTH = { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int y1 = scan.nextInt();
		int y2 = scan.nextInt();
		scan.close();
		
		// 计算1850年到y1-1年年底有多少天
		int count = 0;
		for (int i = 1850; i < y1; i++) {
			count += 365;
			if (isLeap(i)) {
				count += 1;
			}
		}

		for (int i = y1; i <= y2; i++) {
			int index = 0;

			// 计算1850年1月1日到i年a月1日共有多少天
			int day = count;
			count += 365;
			if (isLeap(i)) {
				count += 1;
				index = 1;
			}
			for (int m = 1; m < a; m++) {
				day += MONTH[index][m];
			}

			// w表示i年a月1日是星期几
			int w = (day % 7 + 2) % 7;
			if (w == 0) {
				w = 7;
			}

			// d表示i年a月第b个星期c是几号
			// 若c >= w，则第b个星期c位于第b行，此时，d = 7 * (b - 1) - (w - 1) + c；
			// 若c < w，则第b个星期c位于第b+1行，此时，d = 7 * (b - 1) + 7 - (w - 1) + c。
			int d = 7 * (b - 1) - (w - 1) + c;
			if (c < w) {
				d += 7;
			}
			if (d > MONTH[index][a]) {
				System.out.println("none");
			} else {
				System.out.printf("%04d/%02d/%02d\n", i, a, d);
			}
		}
	}

	public static boolean isLeap(int y) {
		return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
	}
}