import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class IP {
		String ip;
		int[] data = new int[4];
		int len;

		public IP() {
			ip = "";
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		int n = scan.nextInt();
		List<IP> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			IP a = toIP(scan.next());
			list.add(a);
		}
		scan.close();

		list.sort((a, b) -> {
			if (!a.ip.equals(b.ip)) {
				return a.ip.compareTo(b.ip);
			}
			return a.len - b.len;
		});

		list = merge1(list);
		list = merge2(list);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			IP ip = list.get(i);
			for (int j = 0; j < 4; j++) {
				if (j > 0) {
					sb.append('.');
				}
				sb.append(ip.data[j]);// toDecimal(ip.ip.substring(j * 8, (j + 1) * 8)));
			}
			sb.append("/").append(ip.len).append('\n');
		}
		System.out.println(sb.toString());
	}

	public static IP toIP(String line) {
		int count = 0;
		int start = 0, end = 0;
		boolean hasSeparator = false;
		IP ip = new IP();
		for (int j = 0; j < line.length(); j++) {
			if (line.charAt(j) == '.') {
				end = j;
				ip.data[count] = Integer.parseInt(line.substring(start, end));
				ip.ip += toBinaryString(ip.data[count]);
				count++;
				start = j + 1;
			} else if (line.charAt(j) == '/') {
				hasSeparator = true;
				ip.len = Integer.parseInt(line.substring(j + 1));

				ip.data[count] = Integer.parseInt(line.substring(start, j));
				ip.ip += toBinaryString(ip.data[count]);

			}
		}
		if (!hasSeparator) {
			ip.len = 8 * (count + 1);
			ip.data[count] = Integer.parseInt(line.substring(start));
			ip.ip += toBinaryString(ip.data[count]);
		}
		for (int i = 0; i < 3 - count; i++) {
			ip.ip += "00000000";
			ip.data[count + 1 + i] = 0;
		}
		return ip;
	}

	public static boolean isSubset(IP a, IP b) {
		if (a.len > b.len) {
			return false;
		}
		for (int i = 0; i < a.len; i++) {
			if (a.ip.charAt(i) != b.ip.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static List<IP> merge1(List<IP> list) {
		int size = list.size() - 1;
		for (int i = 0; i < size;) {
			if (isSubset(list.get(i), list.get(i + 1))) {
				list.remove(i + 1);
				size--;
			} else {
				i++;
			}
		}
		return list;
	}

	public static boolean canMerge(IP a, IP b) {
		if (a.len != b.len) {
			return false;
		}
		if (a.len - 1 < 0 || a.ip.charAt(a.len - 1) != '0') {
			return false;
		}
		for (int i = 0; i < a.len - 1; i++) {
			if (a.ip.charAt(i) != b.ip.charAt(i)) {
				return false;
			}
		}
		return a.ip.charAt(a.len - 1) != b.ip.charAt(a.len - 1);
	}

	public static List<IP> merge2(List<IP> list) {
		int size = list.size() - 1;
		for (int k = 0; k < size;) {
			if (canMerge(list.get(k), list.get(k + 1))) {
				list.get(k).len -= 1;
				list.remove(k + 1);
				size--;
				if (k != 0) {
					k--;
				}
			} else {
				k++;
			}
		}
		return list;
	}

	public static String toBinaryString(int data) {
		String result = "";
		int[] arr = { 1, 2, 4, 8, 16, 32, 64, 128 };
		for (int i = 7; i >= 0; i--) {
			if (data >= arr[i]) {
				result += '1';
				data -= arr[i];
			} else {
				result += '0';
			}
		}
		return result;
	}

	public static int toDecimal(String binaryString) {
		int result = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			result = (result << 1) + (binaryString.charAt(i) - '0');
		}
		return result;
	}

}
