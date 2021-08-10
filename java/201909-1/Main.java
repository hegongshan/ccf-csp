import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		Apple[] apples = new Apple[n];
		int t = 0;
		for (int i = 0; i < n; i++) {
			int a0 = scan.nextInt();

			int dropCount = 0;
			for (int j = 0; j < m; j++) {
				dropCount += scan.nextInt();
			}
			dropCount = -dropCount;
			apples[i] = new Apple(i + 1, dropCount);

			t += a0 - dropCount;
		}
		scan.close();

		Arrays.sort(apples, (a, b) -> {
			if (a.dropCount != b.dropCount) {
				return b.dropCount - a.dropCount;
			}
			return a.no - b.no;
		});

		System.out.printf("%d %d %d\n", t, apples[0].no, apples[0].dropCount);
	}

	static class Apple {
		int no;
		int dropCount;

		public Apple(int no, int dropCount) {
			this.no = no;
			this.dropCount = dropCount;
		}
	}
}