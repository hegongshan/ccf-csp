import java.util.Scanner;

/**
 * 画图
 * 
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		/*
		 * 1.输入数据, 并用101x101的数组arr存储某点是否已经被包含（最终被染色的单位与点的个数相等）， 1表示该点已经被包含在内，默认为0
		 */
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[][] arr = new int[101][101];
		int x1, x2, y1, y2;
		for (int i = 0; i < total; i++) {
			x1 = scan.nextInt();
			y1 = scan.nextInt();
			x2 = scan.nextInt();
			y2 = scan.nextInt();
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					arr[j][k] = 1;
				}
			}
		}
		scan.close();
		// 2.统计arr中值为1的个数
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				count += arr[i][j];
			}
		}
		System.out.println(count);
	}
}
