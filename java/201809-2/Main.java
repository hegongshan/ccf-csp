import java.util.Scanner;
/**
 * 买菜
 * @author hegongshan
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0;i<n;i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		
		int[][] arr2 = new int[n][2];
		for(int i = 0;i<n;i++) {
			arr2[i][0] = scan.nextInt();
			arr2[i][1] = scan.nextInt();
		}
		scan.close();
		
		int span = 0;
		for(int i= 0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][0] <= arr2[j][1] && arr[i][1] >= arr2[j][0]) {
					span += Math.min(arr[i][1], arr2[j][1])-Math.max(arr[i][0], arr2[j][0]);
				}
			}
		}
		System.out.println(span);
	}
	
}
