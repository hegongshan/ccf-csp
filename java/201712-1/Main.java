import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] intArr = new int[total];
		for(int i = 0;i<intArr.length;i++) {
			intArr[i] = scan.nextInt();
		}
		scan.close();
		int min = Math.abs(intArr[0]-intArr[1]);
		int temp;
		for (int i = 0; i < intArr.length; i++) {
			for (int j = i + 1; j < intArr.length; j++) {
				temp = Math.abs(intArr[i] - intArr[j]);
				if(min > temp) {
					min = temp;
				}
			}
		}
		System.out.println(min);
	}
}
