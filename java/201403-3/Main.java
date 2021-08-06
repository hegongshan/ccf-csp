import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cmd = scan.nextLine();
		List<String> withArgs = new ArrayList<>();
		List<String> noArgs = new ArrayList<>();
		for(int i=0;i<cmd.length();i++) {
			if(cmd.charAt(i) == ':') {
				withArgs.add(String.valueOf(cmd.charAt(i-1)));
			} else if(i+1<cmd.length() && cmd.charAt(i+1) != ':'){
				noArgs.add(String.valueOf(cmd.charAt(i)));
			}
		}
		int cmdCount = Integer.parseInt(scan.nextLine());
		String[] cmdArr = new String[cmdCount];
		for(int i=0;i<cmdCount;i++) {
			cmdArr[i] = scan.nextLine();
		}
		scan.close();
		StringBuilder sb = new StringBuilder(cmdCount);
		
		outerLoop:for(int i=0;i<cmdCount;i++) {
			sb.append("Case "+(i+1)+": ");
			if(cmdArr[i].indexOf(" ") == -1) {
				sb.append("\n");
				continue;
			}
			String arguments = cmdArr[i].substring(cmdArr[i].indexOf(" ")+1);
			String[] pairs = arguments.split("-");
			String[][] arr = new String[pairs.length][2];
			for(int j=0;j<pairs.length;j++) {
				//带参数的命令
				if(pairs[j].indexOf(" ") != -1) {
					if(noArgs.contains(pairs[j].split(" ")[0])) {
						System.out.println(pairs[j]);
						sb.deleteCharAt(sb.length()-1).append("\n");
						continue outerLoop;
					} else {
						sb.append("-"+pairs[j]).append(" ");
					}
				} else {
					//不带参数的命令
					if(noArgs.contains(pairs[j])) {
						arr[j][1] = "-1";
						arr[j][0] = pairs[j];
						//sb.append("-"+pairs[j]+" ");
					} else {
						
					}
				}
			}
			sb.deleteCharAt(sb.length()-1).append("\n");
		}
		System.out.println(sb);
	}
}
