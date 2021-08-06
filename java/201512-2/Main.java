import java.util.Scanner;

/**
 * 消除类游戏
 * 
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] arr = new int[n][m];
		//辅助数组
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scan.nextInt();
				result[i][j] = -1;
			}
		}
		scan.close();

		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m ;j++) {
				if(i< n - 2 && (arr[i][j] == arr[i+1][j] 
						&& arr[i][j] == arr[i+2][j])) {
					result[i][j] = 0;
					result[i+1][j] = 0;
					result[i+2][j] = 0;
				}
				if(j< m - 2 && (arr[i][j] == arr[i][j+1] 
						&& arr[i][j] == arr[i][j+2])) {
					result[i][j] = 0;
					result[i][j+1] = 0;
					result[i][j+2] = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (result[i][j] == -1) {
					sb.append(arr[i][j]).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
