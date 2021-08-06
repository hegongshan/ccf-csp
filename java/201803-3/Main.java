import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static class UrlMapping {
		// URL规则
		String rule;
		// 规则的名字
		String name;

		public UrlMapping(String rule, String name) {
			this.rule = rule;
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		UrlMapping[] mappings = new UrlMapping[n];

		for (int i = 0; i < mappings.length; i++) {
			// 由于\为转义字符，要在字符串中表示普通的\，需要使用\\，因此\\d+需要表示为\\\\d+
			String rule = scan.next().replaceAll("<int>", "(\\\\d+)")
					.replaceAll("<str>", "([-\\\\w\\\\.]+)")
					.replaceAll("<path>", "(.+)");
			// 由于Matcher类的find()方法为部分匹配（只要有一个子串满足正则表达式即可）,
			// 因此加上^和$表示url需要整体匹配(整个字符串满足正则表达式)
			rule = '^' + rule + '$';
			mappings[i] = new UrlMapping(rule, scan.next());
		}
		for (int i = 0; i < m; i++) {
			String url = scan.next();
			boolean flag = false;
			// 暴力搜索匹配的URL规则
			for (UrlMapping urlMapping : mappings) {
				if (matches(urlMapping, url)) {
					flag = true;
					break;
				}
			}
			// 若未找到匹配的URL规则
			if (!flag) {
				System.out.println(404);
			}
		}

		scan.close();
	}

	private static boolean matches(UrlMapping urlMapping, String url) {
		Pattern p = Pattern.compile(urlMapping.rule);
		Matcher m = p.matcher(url);
		// 若不匹配
		if (!m.find()) {
			return false;
		}
		System.out.print(urlMapping.name);
		for (int i = 1; i <= m.groupCount(); i++) {
			String str = m.group(i);
			// 若为数字，则去掉前导零
			if (str.matches("\\d+")) {
				System.out.print(" " + Integer.parseInt(str));
			} else {
				System.out.print(" " + str);
			}
		}
		System.out.println();
		return true;
	}

}
