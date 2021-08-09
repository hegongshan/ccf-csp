import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();

		List<Point> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int xi = scan.nextInt();
			int yi = scan.nextInt();
			list.add(new Point(i, (int)Math.pow(xi - x, 2) + (int)Math.pow(yi - y, 2)));
		}
		scan.close();

		list.sort((a, b) -> {
			if (a.dist != b.dist) {
				return a.dist - b.dist;
			}
			return a.no - b.no;
		});
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i).no);
		}
	}

	static class Point {
		int no, dist;
		Point(int no, int dist) {
			this.no = no;
			this.dist = dist;
		}
	}
}
