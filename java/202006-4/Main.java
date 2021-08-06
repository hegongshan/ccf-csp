import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		char s = String.valueOf(scan.nextInt()).charAt(0);
		scan.close();

		String str = String.valueOf((long) Math.pow(2, n));
		int count = 0;
		for (char c : str.toCharArray()) {
			if (c == s) {
				count++;
			}
		}
		System.out.println(count);
	}
}
