import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static Edge[] edges;
	static int[] ufs;

	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int t;

		public Edge(int u, int v, int t) {
			super();
			this.u = u;
			this.v = v;
			this.t = t;
		}

		@Override
		public int compareTo(Edge o) {
			return this.t - o.t;
		}
	}

	public static int find(int x) {
		while (x != ufs[x]) {
			ufs[x] = ufs[ufs[x]];
			x = ufs[x];
		}
		return x;
	}

	public static int kruskal(int n) {
		// 1.升序
		Arrays.sort(edges);

		// 2.初始化并查集
		for (int i = 1; i <= n; i++) {
			ufs[i] = i;
		}

		// 3.最小生成树
		int count = 0, result = 0;
		for (int i = 0; i < edges.length; i++) {
			Edge edge = edges[i];
			// 若不会形成环
			int u = find(edge.u);
			int v = find(edge.v);
			if (u != v) {
				count++;
				ufs[u] = v;
				result = Math.max(edge.t, result);
				if (count == n - 1) {
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		@SuppressWarnings("unused")
		int root = Integer.parseInt(br.readLine());

		edges = new Edge[m];
		ufs = new int[n + 1];

		for (int i = 0; i < m; i++) {
			String[] sArr = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]));

		}
		br.close();

		System.out.println(kruskal(n));
	}
}