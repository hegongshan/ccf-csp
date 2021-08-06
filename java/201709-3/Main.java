import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static Map<String, String> json = new HashMap<>();

	// 返回键名或键值最后一个字符的索引号
	public static int offset(int i, String str) {
		i++;
		while (i < str.length() && str.charAt(i) != '"') {
			if (str.charAt(i) == '\\') {
				i++;
			}
			i++;
		}
		return i;
	}

	// 解析json字符串，parent表示当前处理的json串是哪个键的值，
	// str为尚未解析的字符串，返回值为本次解析的json串的长度
	public static int parseJSON(String parent, String str) {

		String key = null;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '}') {
				return i;
			}
			if (str.charAt(i) == ' ' || str.charAt(i) == ',') {
				continue;
			}
			// 获取键名
			if (str.charAt(i) == '"') {
				int index = offset(i, str);
				// 将键名中的\\替换为\，\"替换为"
				key = str.substring(i + 1, index).replace("\\\\", "\\").replace("\\\"", "\"");
				i = index;
				continue;
			}

			// 获取键值
			if (str.charAt(i) == ':') {
				// 去掉可能存在的空格
				while (str.charAt(++i) == ' ') {
				}
				// 若值为字符串
				if (str.charAt(i) == '"') {
					int index = offset(i, str);
					String value = str.substring(i + 1, index).replace("\\\\", "\\").replace("\\\"", "\"");
					i = index;
					if (parent.isEmpty()) {
						json.put(key, value);
					} else {
						json.put(parent + '.' + key, value);
					}
					continue;
				}
				// 若值为对象
				// 去掉左花括号{后面可能存在的空格
				while (str.charAt(++i) == ' ') {
				}
				String newParent;
				if (parent.isEmpty()) {
					newParent = key;
				} else {
					newParent = parent + '.' + key;
				}
				// 用{}标记newParent的值为对象
				json.put(newParent, "{}");
				// 解析子串
				i += parseJSON(newParent, str.substring(i));
			}

		}
		return str.length();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(scan.nextLine().trim());
		}

		parseJSON("", sb.toString());

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String key = scan.nextLine().trim();
			if (!json.containsKey(key)) {
				out.append("NOTEXIST\n");
			} else if (json.get(key) == "{}") {
				out.append("OBJECT\n");
			} else {
				out.append("STRING ").append(json.get(key)).append('\n');
			}
		}
		scan.close();

		System.out.println(out.toString());
	}
}