import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int L = scan.nextInt();

		int[] A = new int[L];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int x = scan.nextInt();
				A[x]++;
			}
		}
		scan.close();

		for (int i = 0; i < L; i++) {
			if (i > 0) {
				System.out.print(" ");
			}
			System.out.print(A[i]);
		}
		System.out.printf("\n");
	}
}
