package com.hegongshan.ccfcsp;

import java.util.Scanner;

public class T20180303 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] data = toIntArray(scan.nextLine().split(" "));
		UrlMapping[] mappings = new UrlMapping[data[0]];
		String[] url = new String[data[1]];
		for (int i = 0; i < data[0]; i++) {
			String[] sArr = scan.nextLine().split(" ");
			UrlMapping urlMapping = new UrlMapping();
			urlMapping.setExpression(sArr[0]);
			urlMapping.setName(sArr[1]);
			mappings[i] = urlMapping;
		}
		for (int i = 0; i < url.length; i++) {
			url[i] = scan.nextLine();
		}

		for (int i = 0; i < url.length; i++) {
			boolean flag = false;
			for (UrlMapping urlMapping : mappings) {
				if (matches(urlMapping, url[i])) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(404);
			}
		}
		scan.close();
	}

	private static boolean matches(UrlMapping urlMapping, String url) {

		String expression = urlMapping.getExpression();
		String[] mappingArr = expression.split("/");
		String[] urlArr = url.split("/");
		if ((mappingArr.length < urlArr.length && !expression.endsWith("<path>"))
				|| mappingArr.length > urlArr.length) {
			return false;
		}
		if (expression.endsWith("/") && !url.endsWith("/")) {
			return false;
		}
		if ((!expression.endsWith("<path>") && !expression.endsWith("/")) && url.endsWith("/")) {
			return false;
		}
		String[] args = new String[urlArr.length];
		int count = 0;
		for (int i = 0; i < mappingArr.length; i++) {
			if (mappingArr[i].equals("<str>")) {
				if (!urlArr[i].matches("[\\w-\\.]+") || urlArr[i].matches("[0-9]+")) {//<str>不能匹配纯数字
					return false;
				}
				args[count++] = urlArr[i];
			} else if (mappingArr[i].equals("<int>")) {
				if (!urlArr[i].matches("[0-9]+")) {
					return false;
				}
				args[count++] = deleteStartsZero(urlArr[i]);
			} else if (mappingArr[i].equals("<path>")) {
				StringBuilder sb = new StringBuilder(urlArr[i]);
				for (int j = i + 1; j < urlArr.length; j++) {
					sb.append("/" + urlArr[j]);
				}
				if (url.endsWith("/")) {// 加上url结尾的/
					sb.append("/");
				}
				args[count++] = sb.toString();
			} else if (!mappingArr[i].equals(urlArr[i])) {
				return false;
			}
		}
		StringBuilder sb = new StringBuilder(urlMapping.getName() + " ");
		for (int k = 0; k < count; k++) {
			sb.append(args[k] + " ");
		}
		System.out.println(sb);
		return true;
	}
	
	//更简洁的做法：String.valueOf(Integer.parseInt(str));
	private static String deleteStartsZero(String str) {
		int i;
		for(i = 0 ; i < str.length();i++) {
			if(str.charAt(i) != '0') {
				break;
			}
		}
		return str.substring(i);
	}

	private static int[] toIntArray(String[] sArr) {
		int[] intArr = new int[sArr.length];
		for (int i = 0; i < sArr.length; i++) {
			intArr[i] = Integer.parseInt(sArr[i]);
		}
		return intArr;
	}

	private static class UrlMapping {
		String expression;
		String name;

		public String getExpression() {
			return expression;
		}

		public void setExpression(String expression) {
			this.expression = expression;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
