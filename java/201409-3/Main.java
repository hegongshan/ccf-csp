import java.util.Scanner;

/**
 * 字符串匹配
 * @author hegongshan　https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		//------------输入开始----------------------
		Scanner scan = new Scanner(System.in);
		String pattern = scan.nextLine();
		//是否大小写敏感，1表示敏感，0表示不敏感
		boolean ignoreCase = Integer.parseInt(scan.nextLine()) == 0 ? true : false; 
		int count = Integer.parseInt(scan.nextLine());
		String[] sArr = new String[count];
		for (int i = 0; i < sArr.length ; i++) {
			sArr[i] = scan.nextLine();
		}
		scan.close();
		//------------输入结束-----------------------
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sArr.length; i++) {
			boolean ignoreCaseContains = ignoreCase && sArr[i].toLowerCase().contains(pattern.toLowerCase());
			boolean contains = !ignoreCase && sArr[i].contains(pattern);
			if(ignoreCaseContains || contains) {
				sb.append(sArr[i]).append("\n");					
			}
		}
		System.out.println(sb);
	}
}
