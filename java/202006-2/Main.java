import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();

		Pair[] arrA = new Pair[a];
		Pair[] arrB = new Pair[b];
		for (int i = 0; i < a; i++) {
			arrA[i] = new Pair(scan.nextInt(), scan.nextLong());
		}
		for (int i = 0; i < b; i++) {
			arrB[i] = new Pair(scan.nextInt(), scan.nextLong());
		}
		scan.close();

		long innerProduct = 0L;
		int idxA = 0;
		int idxB = 0;
		int i = 0;
		while (i < n && idxA < a && idxB < b) {
			Pair pA = arrA[idxA];
			Pair pB = arrB[idxB];

			if (pA.index == i && pA.index == pB.index) {
				innerProduct += pA.value * pB.value;
				idxA++;
				idxB++;
			} else if (pA.index == i) {
				idxA++;
			} else if (pB.index == i){
				idxB++;
			}
			i++;
		}

		System.out.println(innerProduct);
	}

	static class Pair {
		int index;
		long value;

		public Pair(int index, long value) {
			this.index = index;
			this.value = value;
		}

	}

}
