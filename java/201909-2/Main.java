import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = 0;
		boolean[] d = new boolean[n];
		for (int i = 0; i < n; i++) {
			int m = scan.nextInt();
			int a1 = scan.nextInt();
			for (int j = 2; j <= m; j++) {
				int aj = scan.nextInt();
				if (0 < aj && aj < a1) {
					// 掉落
					a1 = aj;
					d[i] = true;
				} else if (aj <= 0) {
					// 疏果
					a1 += aj;
				}
			}
			t += a1;
		}
		scan.close();

		int d_count = 0;
		int e = 0;
		for (int i = 0; i < n; i++) {
			if (!d[i]) {
				continue;
			}
			d_count ++;
			if (d[(i - 1 + n) % n] == d[i] && d[i] == d[(i + 1 + n) % n]) {
				e++;
			}
		}
		System.out.printf("%d %d %d\n", t, d_count, e);
	}
}