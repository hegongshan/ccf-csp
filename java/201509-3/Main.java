import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 模板生成系统
 * 
 * @author hegongshan https://www.hegongshan.com
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 保存输入的数据
		String[] sArr = scan.nextLine().split(" ");
		int m = Integer.parseInt(sArr[0]);
		int n = Integer.parseInt(sArr[1]);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(scan.nextLine()).append("\n");
		}

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			int index = line.indexOf(' ');
			String key = line.substring(0, index);
			// 去掉首尾的双引号
			String value = line.substring(index + 2, line.length() - 1);
			map.put(key, value);
		}
		scan.close();

		for (int i = 0; i < sb.length();) {
			// 从第i个位置开始，向后寻找子串第一次出现的位置
			int start = sb.indexOf("{{ ", i);
			if (start == -1) {
				break;
			}
			int end = sb.indexOf(" }}", start + 3);
			if (end == -1) {
				break;
			}
			// 获取变量名
			String key = sb.substring(start + 3, end);
			// 若变量为定义，则生成空串
			String value = map.containsKey(key) ? map.get(key) : "";
			// 替换模板变量
			sb.replace(start, end + 3, value);
			// 因为模板不递归生成，故跳过替换后的那段字符串
			i = start + value.length();
		}
		System.out.println(sb.toString());
		
		
		/*//正则表达式的解法，得分为90，显示运行错误
		// 使用正则表达式替换模板变量
		Pattern p = Pattern.compile("\\{\\{ \\D\\w{0,15} \\}\\}");
		Matcher matcher = p.matcher(sb);
		StringBuffer sbuff = new StringBuffer();
		while (matcher.find()) {
			String var = matcher.group();
			String key = var.substring(3, var.length() - 3);
			matcher.appendReplacement(sbuff, map.containsKey(key) ? map.get(key) : "");
		}
		matcher.appendTail(sbuff);
		System.out.println(sbuff.toString());*/
		
	}
}
