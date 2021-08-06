import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		List<Point> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			String[] sArr = line.split(" ");
			list.add(new Point(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), sArr[2].charAt(0)));
		}

		for (int i = 0; i < m; i++) {
			long theta0 = scan.nextLong();
			long theta1 = scan.nextLong();
			long theta2 = scan.nextLong();

			boolean greaterThanZeroA = true;
			boolean isSuccessful = true;
			for (int j = 0; j < list.size(); j++) {
				Point p = list.get(j);

				long result = theta0 + p.x * theta1 + p.y * theta2;
				if (j == 0) {
					if (p.type == 'A') {
						if (result < 0) {
							greaterThanZeroA = false;
						}
					} else {
						if (result > 0) {
							greaterThanZeroA = false;
						}
					}
				} else {
					if (p.type == 'A') {
						if ((greaterThanZeroA && result < 0) || (!greaterThanZeroA && result > 0)) {
							isSuccessful = false;
							break;
						}
					} else {
						if ((greaterThanZeroA && result > 0) || (!greaterThanZeroA && result < 0)) {
							isSuccessful = false;
							break;
						}
					}
				}

			}
			if (isSuccessful) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
		scan.close();
	}

	static class Point {
		int x, y;
		char type;

		public Point(int x, int y, char type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
}
