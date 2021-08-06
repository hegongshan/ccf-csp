import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		Integer[] arr = toIntegerArray(str.split("\\s+"));
		int sum = 0;
		int count = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == 1) {
				sum += 1;
			} else if(arr[i] == 2) {
				if(i == 0 || arr[i-1] == 1) {
					sum += 2;
				} else {
					count = count(arr,i);
					sum += 2 * count;
				}
			}
		}
		System.out.println(sum);
		scan.close();
	}
	
	private static int count(Integer[] arr,int i) {
		int count = 0;
		for(int j = i ; j >= 0 ; j--) {
			if(arr[j]==1) {
				break;
			}
			count++;
		}
		return count;
	}
	
	private static Integer[] toIntegerArray(String[] sArr) {
		Integer[] intArr = new Integer[sArr.length];
		for(int i = 0 ; i < sArr.length ;i++) {
			intArr[i] = Integer.valueOf(sArr[i]);
		}
		return intArr;
	}
}
