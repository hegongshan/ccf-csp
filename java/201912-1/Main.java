import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		int[] arr = new int[4];
		int cnt = 1;
		int cur = 0;
		while (cnt <= n) {
			if (isSkip(++cur)) {
				arr[(cur - 1) % 4]++;
			} else {
				cnt ++;
			}
		}
		
		for (int x : arr) {
			System.out.println(x);
		}
	}
	
	private static boolean isSkip(int x) {
		if (x % 7 == 0) {
			return true;
		}
		while (x > 0) {
			if (x % 10 == 7) {
				return true;
			}
			x /= 10;
		}
		return false;
	}
}
