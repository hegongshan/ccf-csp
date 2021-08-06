import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int q = scan.nextInt();
		char[][] graph = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				graph[i][j] = '.';
			}
		}

		for (int k = 0; k < q; k++) {
			int status = scan.nextInt();
			// 填充
			if (status == 1) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				char c = scan.next().charAt(0);
				//dfs(graph, x, y, c, m, n);
				Queue<Point> qu = new LinkedList<>();
				qu.add(new Point(x,y));
				while(!qu.isEmpty()) {
					Point p = qu.poll();
					x = p.x;
					y = p.y;
					int i = n - 1 - y, j = x;
					// 如果遇到画布边缘，或者已经画好的线段，或者该位置已经填充过了
					if (x < 0 || x >= m || y < 0 || y >= n 
                        || graph[i][j] == '-' || graph[i][j] == '|' || graph[i][j] == '+'
						|| graph[i][j] == c) {
						continue;
					}
					graph[i][j] = c;
					qu.add(new Point(p.x,y+1));
					qu.add(new Point(x,y-1));
					qu.add(new Point(x-1,y));
					qu.add(new Point(x+1,y));
				}
				continue;
			}
            // 画线段
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			int i, j, temp;
			// 竖直线段
			if (x1 == x2) {
				if (y1 > y2) {
					temp = y1;
					y1 = y2;
					y2 = temp;
				}
				for (; y1 <= y2; y1++) {
					i = n - 1 - y1;
					j = x1;
					if (graph[i][j] == '-' || graph[i][j] == '+') {
						graph[i][j] = '+';
					} else {
						graph[i][j] = '|';
					}
				}
			} else {
				// 水平线段
				if (x1 > x2) {
					temp = x1;
					x1 = x2;
					x2 = temp;
				}
				for (; x1 <= x2; x1++) {
					i = n - 1 - y1;
					j = x1;
					if (graph[i][j] == '|' || graph[i][j] == '+') {
						graph[i][j] = '+';
					} else {
						graph[i][j] = '-';
					}
				}
			}
		}

		scan.close();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(graph[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	// 使用递归，得分90，显示运行错误，可能是递归层数过深，导致栈溢出
	/*public static void dfs(char[][] graph, int x, int y, char c, int m, int n) {
		int i = n - 1 - y, j = x;
		// 如果遇到画布边缘，或者已经画好的线段，或者该位置已经填充过了
		if (x < 0 || x >= m || y < 0 || y >= n || graph[i][j] == '-' || graph[i][j] == '|' || graph[i][j] == '+'
				|| graph[i][j] == c) {
			return;
		}
		graph[i][j] = c;
		// 填充相邻位置，上下左右
		dfs(graph, x, y + 1, c, m, n);
		dfs(graph, x, y - 1, c, m, n);
		dfs(graph, x - 1, y, c, m, n);
		dfs(graph, x + 1, y, c, m, n);

	}*/
}
class Point {
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}