import java.util.Scanner;

/**
 * 最大的矩形
 * 
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] h = new int[total];
		for (int i = 0; i < total; i++) {
			h[i] = scan.nextInt();
		}
		scan.close();
		int area, maxArea = 0, minHeight;
		for (int i = 0; i < h.length; i++) {
			minHeight = h[i];
			for (int j = i; j < h.length; j++) {
				minHeight = Math.min(minHeight, h[j]);
				area = (j - i + 1) * minHeight;
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		System.out.println(maxArea);
	}
}
