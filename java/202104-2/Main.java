import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int L = scan.nextInt();
		int r = scan.nextInt();
		int t = scan.nextInt();

		int[][] graySum = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = scan.nextInt();
				if (j == 0) {
					graySum[i][j] = x;
				} else {
					graySum[i][j] = graySum[i][j - 1] + x;
				}
			}
		}
		scan.close();

		int grayAreaCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				int sumOfGray = 0;
				int neighborMinX = i - r < 0 ? 0 : i - r;
				int neighborMaxX = i + r >= n ? n - 1 : i + r;

				int neighborMinY = j - r < 0 ? 0 : j - r;
				int neighborMaxY = j + r >= n ? n - 1 : j + r;

				int numOfNeighbor = (neighborMaxX - neighborMinX + 1) * (neighborMaxY - neighborMinY + 1);
				int upperLimit = numOfNeighbor * t;

				for (int k = neighborMinX; k <= neighborMaxX; k++) {
					if (neighborMinY == 0) {
						sumOfGray += graySum[k][neighborMaxY];
					} else {
						sumOfGray += graySum[k][neighborMaxY] - graySum[k][neighborMinY - 1];
					}

					if (sumOfGray > upperLimit) {
						break;
					}
				}
				if (sumOfGray <= upperLimit) {
					grayAreaCount += 1;
				}
			}
		}
		System.out.println(grayAreaCount);
	}
}
