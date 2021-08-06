import java.util.Scanner;

/**
 * 202012-1.期末预测之安全指数
 * @author hegongshan https://www.hegongshan.com
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		int n = scan.nextInt();

		int score = 0;
		for (int i = 0; i < n; i++) {
			int weighti = scan.nextInt();
			int scorei = scan.nextInt();
			score += weighti * scorei;
		}
		scan.close();

		score = Integer.max(0, score);
		System.out.println(score);
	}
}