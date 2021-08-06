import java.util.Scanner;
/**
 * @author hegongshan https://www.baidu.com
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] points = new int[n][4];
		for(int i=0;i<n;i++) {
			points[i][0] = scan.nextInt();
			points[i][1] = scan.nextInt();
			points[i][2] = scan.nextInt();
			points[i][3] = scan.nextInt();
		}
		int[][] clicks = new int[m][2];
		for(int j=0;j<m;j++) {
			clicks[j][0] = scan.nextInt();
			clicks[j][1] = scan.nextInt();
		}
		scan.close();
		
		StringBuilder sb = new StringBuilder();
		//保存窗口编号
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] += i+1;
		}
		for(int i = 0;i<m;i++) {
			boolean flag = false;
			for(int j=n-1;j>=0;j--) {
				if(points[j][0] <= clicks[i][0] && clicks[i][0] <= points[j][2]
						&& points[j][1] <= clicks[i][1] && clicks[i][1] <= points[j][3]) {
					flag = true;
					sb.append(arr[j]).append("\n");
					int temp = arr[arr.length-1];
					arr[arr.length-1] = arr[j];
					arr[j] = temp;
					top(points,j);
					break;
				}
			}
			if(!flag) {
				sb.append("IGNORED\n");
			}
		}
		System.out.println(sb);
	}
	//置顶
	public static void top(int[][] points,int j) {
		if(j < 0 || j >= points.length) {
			return;
		}
		int temp1 = points[j][0];
		int temp2 = points[j][1];
		int temp3 = points[j][2];
		int temp4 = points[j][3];
		for(int i=j;i<points.length-1;i++) {
			points[i] = points[i+1];
		}
		int s = points.length - 1;
		points[s][0] = temp1;
		points[s][1] = temp2;
		points[s][2] = temp3;
		points[s][3] = temp4;
	}
}
