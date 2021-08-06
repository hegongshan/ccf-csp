import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<Point> matrix = new ArrayList<>();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			matrix.add(new Point(x, y));
		}
		scan.close();

		int[] counts = new int[5];

		int[][] directions1 = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		int[][] directions2 = { { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
		for (Point p : matrix) {
			boolean isValid = true;
			for (int[] arr : directions1) {
				isValid = isValid && matrix.contains(new Point(p.x + arr[0], p.y + arr[1]));
				if (!isValid) {
					break;
				}
			}
			if (!isValid) {
				continue;
			}
			int score = 0;
			for (int[] arr : directions2) {
				score += matrix.contains(new Point(p.x + arr[0], p.y + arr[1])) ? 1 : 0;
			}
			counts[score]++;
		}
		for (int x : counts) {
			System.out.println(x);
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
}
