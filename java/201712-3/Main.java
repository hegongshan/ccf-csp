import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	// 1亿
	public static final long HUNDRED_MILLION = 100000000L;

	// 1百万
	public static final long MILLION = 1000000L;

	public static final int[][] MONTHS = { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	// 将字符串形式的月份（星期）映射为数字形式
	public static Map<String, Integer> monthAndWeekMap = new HashMap<>();

	public static Map<Long, List<String>> resultMap = new TreeMap<>();

	static {
		monthAndWeekMap.put("jan", 1);
		monthAndWeekMap.put("feb", 2);
		monthAndWeekMap.put("mar", 3);
		monthAndWeekMap.put("apr", 4);
		monthAndWeekMap.put("may", 5);
		monthAndWeekMap.put("jun", 6);
		monthAndWeekMap.put("jul", 7);
		monthAndWeekMap.put("aug", 8);
		monthAndWeekMap.put("sep", 9);
		monthAndWeekMap.put("oct", 10);
		monthAndWeekMap.put("nov", 11);
		monthAndWeekMap.put("dec", 12);
		monthAndWeekMap.put("sun", 0);
		monthAndWeekMap.put("mon", 1);
		monthAndWeekMap.put("tue", 2);
		monthAndWeekMap.put("wed", 3);
		monthAndWeekMap.put("thu", 4);
		monthAndWeekMap.put("fri", 5);
		monthAndWeekMap.put("sat", 6);
	}

	// 一行配置
	static class Config {
		Set<Integer> minutes;
		Set<Integer> hours;
		Set<Integer> dayOfMonth;
		Set<Integer> month;
		Set<Integer> command;
		Set<Integer> dayOfWeek;
	}

	// 是否为闰年
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	// 计算y年m月d日是星期几，已知1970年1月1日是星期四
	public static int dayOfWeek(int y, int m, int d) {
		int days = 0;
		for (int i = 1970; i < y; i++) {
			days += 365;
			if (isLeapYear(i)) {
				days += 1;
			}
		}

		boolean isLeap = isLeapYear(y);
		for (int i = 1; i < m; i++) {
			days += MONTHS[isLeap ? 1 : 0][i];
		}

		days += d;
		return (days % 7 + 4 - 1) % 7;
	}

	// 判断字符串是否为数字
	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	// 解析月份和星期，将字符串形式转换为数字形式
	public static int parseMonthAndWeek(String str) {
		if (isDigit(str)) {
			return Integer.parseInt(str);
		}
		return monthAndWeekMap.get(str.toLowerCase());
	}

	// 解析输入的配置信息
	public static Config parseConfig(String[] crontab) {
		Config cfg = new Config();
		cfg.minutes = parseConfig0(crontab, 0);
		cfg.hours = parseConfig0(crontab, 1);
		cfg.dayOfMonth = parseConfig0(crontab, 2);
		cfg.month = parseConfig0(crontab, 3);
		cfg.dayOfWeek = parseConfig0(crontab, 4);
		return cfg;
	}

	private static Set<Integer> parseConfig0(String[] crontab, int i) {
		// 当前类型的上下界
		int low = 0, high = 0;
		Set<Integer> list = new HashSet<>();
		// 处理星号(星号只能单独出现)
		if ("*".equals(crontab[i])) {
			if (i == 0) { // 分钟
				high = 59;
			} else if (i == 1) { // 小时
				high = 23;
			} else if (i == 2) { // 月份中的天数
				low = 1;
				high = 31;
			} else if (i == 3) { // 月份
				low = 1;
				high = 12;
			} else { // 星期
				high = 6;
			}
			for (int j = low; j <= high; j++) {
				list.add(j);
			}
			return list;
		}
		// 处理-和,
		String[] sArr = crontab[i].split(",");
		for (int j = 0; j < sArr.length; j++) {
			int index = sArr[j].indexOf("-");
			// 若不包含-
			if (index == -1) {
				list.add(parseMonthAndWeek(sArr[j]));
			} else {
				int start = parseMonthAndWeek(sArr[j].substring(0, index));
				int end = parseMonthAndWeek(sArr[j].substring(index + 1));
				while (start <= end) {
					list.add(start++);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		long s = scan.nextLong();
		long t = scan.nextLong();

		String[] crontab = new String[5];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < crontab.length; j++) {
				crontab[j] = scan.next();
			}
			String cmd = scan.next();

			// 解析配置信息
			Config cfg = parseConfig(crontab);

			for (int y = (int) (s / HUNDRED_MILLION); y <= t / HUNDRED_MILLION; y++) {
				for (int m : cfg.month) {
					for (int d : cfg.dayOfMonth) {
						// 若d超过了y年m月的最大天数
						if (d > MONTHS[isLeapYear(y) ? 1 : 0][m]) {
							continue;
						}
						// 若y年m月d日的星期在day of week中
						if (cfg.dayOfWeek.contains(dayOfWeek(y, m, d))) {
							for (int h : cfg.hours) {
								for (int min : cfg.minutes) {
									// 计算任务调度的时间
									long date = (long) y * HUNDRED_MILLION + m * MILLION + d * 10000 + h * 100 + min;
									// 包含开始时间，不包含结束时间
									if (s <= date && date < t) {
										if (!resultMap.containsKey(date)) {
											List<String> cmds = new ArrayList<>();
											cmds.add(cmd);
											resultMap.put(date, cmds);
										} else {
											resultMap.get(date).add(cmd);
										}
									}
								}
							}
						}

					}
				}
			}
		}

		scan.close();

		// 输出
		resultMap.forEach((date, cmds) -> {
			for (String cmd : cmds) {
				System.out.println(date + " " + cmd);
			}
		});
	}

}
