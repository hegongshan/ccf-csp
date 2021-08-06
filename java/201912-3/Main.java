import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		String term = "(([A-Z]+)|([A-Z][a-z]+))|(\\((([A-Z]+)|([A-Z][a-z]+))\\))";

		String formula = String.format("(%s[0-9]*)", term);
		String expression = "([0-9]*" + formula + ")" + "|([0-9]*" + formula + "\\+[0-9]*" + formula + ")+";
		String regex = String.format("%s=%s", expression, expression);
		for (int i = 0; i < n; i++) {
			String equation = scan.next();
			if (equation.matches(regex)) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
		scan.close();
	}
}
