import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		String line = null;

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.isEmpty()) {
				continue;
			}
			// 处理标题
			if (line.charAt(0) == '#') {
				// 计算标题的等级
				int level = 0;
				while (level < line.length() && line.charAt(level) == '#') {
					level++;
				}
				sb.append(String.format("<h%d>%s</h%d>\n", level, parseInline(line.substring(level).trim()), level));
				continue;
			}

			// 处理无序列表
			if (line.charAt(0) == '*') {
				sb.append("<ul>\n");
				sb.append("<li>").append(parseInline(line.substring(1).trim())).append("</li>\n");
				while (scan.hasNextLine() && !(line = scan.nextLine()).isEmpty()) {
					sb.append("<li>").append(parseInline(line.substring(1).trim())).append("</li>\n");
				}
				sb.append("</ul>\n");
				continue;
			}

			// 处理段落
			sb.append("<p>").append(parseInline(line));
			while (scan.hasNextLine() && !(line = scan.nextLine()).isEmpty()) {
				sb.append('\n').append(parseInline(line));
			}
			sb.append("</p>\n");
		}
		scan.close();

		System.out.println(sb.toString());
	}

	// 处理行内结构（强调和超级链接）
	public static String parseInline(String line) {
		return parseLink(parseEm(line));
	}

	// 处理强调
	public static String parseEm(String line) {

		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("_[^_]+_");
		Matcher m = p.matcher(line);
		while (m.find()) {
			String str = m.group();
			m.appendReplacement(sb, "<em>" + str.substring(1, str.length() - 1) + "</em>");
		}
		m.appendTail(sb);
		return sb.toString();

	}

	// 处理超级链接
	public static String parseLink(String line) {

		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("\\[[^\\]]+\\]\\([^\\)]+\\)");
		Matcher m = p.matcher(line);
		while (m.find()) {
			String str = m.group();
			int index = str.indexOf(']');
			String text = str.substring(1, index);
			String link = str.substring(index + 2, str.length() - 1);
			m.appendReplacement(sb, "<a href=\"" + link + "\">" + text + "</a>");
		}
		m.appendTail(sb);
		return sb.toString();
	}
}
