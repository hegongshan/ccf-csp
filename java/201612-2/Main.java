import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.close();
		double S = 0;
		if (T <= 3500) {
			S = T;
		} else if (T <= 3500 + 1500 * (1 - 0.03)) {
			S = (T - 3500) / (1 - 0.03) + 3500;
		} else if (T <= 3500 + 1500 * (1 - 0.03) + (4500 - 1500) * (1 - 0.1)) {
			S = (T - 3500 - 1500 * (1 - 0.03)) / (1 - 0.1) + 5000;
		} else if (T <= 3500 + 1500 * (1 - 0.03) + (4500 - 1500) * (1 - 0.1) + (9000 - 4500) * (1 - 0.2)) {
			S = (T - 3500 - 1500 * (1 - 0.03) - 3000 * (1 - 0.1)) / (1 - 0.2) + 8000;
		} else if (T <= 3500 + 1500 * (1 - 0.03) + (4500 - 1500) * (1 - 0.1) + (9000 - 4500) * (1 - 0.2)
				+ (35000 - 9000) * (1 - 0.25)) {
			S = (T - 3500 - 1500 * (1 - 0.03) - 3000 * (1 - 0.1) - 4500 * (1 - 0.2)) / (1 - 0.25) + 12500;
		} else if (T <= 3500 + 1500 * (1 - 0.03) + (4500 - 1500) * (1 - 0.1) + (9000 - 4500) * (1 - 0.2)
				+ (35000 - 9000) * (1 - 0.25) + (55000 - 35000) * (1 - 0.3)) {
			S = (T - 3500 - 1500 * (1 - 0.03) - 3000 * (1 - 0.1) - 4500 * (1 - 0.2) - 26000 * (1 - 0.25)) / (1 - 0.3)
					+ 38500;
		} else if (T <= 3500 + 1500 * (1 - 0.03) + (4500 - 1500) * (1 - 0.1) + (9000 - 4500) * (1 - 0.2)
				+ (35000 - 9000) * (1 - 0.25) + (55000 - 35000) * (1 - 0.3) + (80000 - 55000) * (1 - 0.35)) {
			S = (T - 3500 - 1500 * (1 - 0.03) - 3000 * (1 - 0.1) - 4500 * (1 - 0.2) - 26000 * (1 - 0.25)
					- 20000 * (1 - 0.3)) / (1 - 0.35) + 58500;
		} else {
			S = (T - 3500 - 1500 * (1 - 0.03) - 3000 * (1 - 0.1) - 4500 * (1 - 0.2) - 26000 * (1 - 0.25)
					- 20000 * (1 - 0.3) - 25000 * (1 - 0.35)) / (1 - 0.45) + 83500;
		}
		System.out.println((int) S);
	}
}
