import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * 数组推导 http://118.190.20.162/view.page?gpid=T129
 * @author hegongshan
 * @date 2021-10-05
 */
public class Main {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int minSum = 0, maxSum = 0;
		for (int i = 0; i < n; i++) {
			int bi = scan.nextInt();
			if (!set.contains(bi)) {
				minSum += bi;
				set.add(bi);
			}
			maxSum += bi;
		}
		scan.close();

		System.out.println(maxSum);
		System.out.println(minSum);
	}
}