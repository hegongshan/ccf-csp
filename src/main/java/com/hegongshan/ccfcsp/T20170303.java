package com.hegongshan.ccfcsp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T20170303 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = null;
		StringBuilder sb = new StringBuilder();
		int total = 0;
		while(total <= 10) {
			total++;
			line = scan.nextLine();
			if(line.startsWith("#")) {
				int hCount = 0;
				for (int i = 0; i < line.length(); i++) {
					if(line.charAt(i)!='#') {
						break;
					}
					hCount++;
				}
				sb.append("<h"+hCount+">"+handleEm(line.substring(hCount).trim())+"</h"+hCount+">\n");
			} else if(line.startsWith("*")) {
				sb.append("<ul>＜li>").append(handleEm(line.substring(1).trim())).append("</li>\n");
				sb.append("</ul>");
			} else {
				sb.append("<p>").append(handleEm(line.trim())).append("</p>");
			}
		}
		scan.close();
		System.out.println(sb.toString());
	}
	
	public static String handleEm(String line) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("_[a-zA-Z0-9]+_");
		Matcher m = p.matcher(line.trim());
		while(m.find()) {
			m.appendReplacement(sb, "<em>"+handleLink(m.group().substring(1, m.group().length()))+"</em>");
		}
		return handleLink(sb.toString());
	}
	
	public static String handleLink(String line) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("[\\w+](\\w+)");
		Matcher m = p.matcher(line.trim());
		while(m.find()) {
			String link = m.group();
			int index = 0;
			for (int i = 1; i < link.length(); i++) {
				if(link.charAt(i) == ']') {
					index = i;
					break;
				}
			}
			m.appendReplacement(sb, "<a href=\""+link.substring(1, index)+"\">"+link.substring(index+2, link.length()-1)+"</a>");
		}
		return sb.toString();
	}
}
