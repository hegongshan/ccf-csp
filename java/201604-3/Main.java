import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = Integer.parseInt(scan.nextLine());
		String currentDir = scan.nextLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < p; i++) {
			String dir = scan.nextLine();
			// 若dir为空字符串，则正规化操作的结果就是当前目录
			if (dir.isEmpty()) {
				sb.append(currentDir).append('\n');
				continue;
			}

			// 若dir为相对路径，则将currentDir与dir通过路径分隔符/拼接起来
			if (dir.charAt(0) != '/') {
				dir = currentDir + '/' + dir;
			}

			// 处理.和..
			LinkedList<String> list = new LinkedList<>();
			for (String str : dir.split("/")) {
				if (str.equals(".") || str.isEmpty()) {
					continue;
				}
				if (str.equals("..")) {
					if (!list.isEmpty()) {
						list.removeLast();
					}
				} else {
					list.add(str);
				}
			}

			// 若为根目录
			if (list.isEmpty()) {
				sb.append('/');
			} else {
				// 输出目录
				for (String str : list) {
					sb.append('/').append(str);
				}
			}

			sb.append('\n');
		}
		scan.close();

		System.out.println(sb.toString());
	}

}
