import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static class Privilege {
		// 权限名
		String name;
		// 权限等级
		Integer level;

		public Privilege(String name, Integer level) {
			this.name = name;
			this.level = level;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int categoryCount = scan.nextInt();
		// 由于输入保证合法性，因此，本题可以不对第2至p+1行的权限做任何处理
		for (int i = 0; i < categoryCount; i++) {
			scan.next();
		}

		// 存储所有角色及其具有的所有权限
		Map<String, Map<String, Integer>> roles = new HashMap<>();
		int roleCount = scan.nextInt();
		for (int i = 0; i < roleCount; i++) {
			String role = scan.next();

			// 存储角色role具有的所有权限
			Map<String, Integer> privileges = new HashMap<>();
			int s = scan.nextInt();
			for (int j = 0; j < s; j++) {
				Privilege p = split(scan.next());
				// 权限可以重复出现，如果带等级的权限重复出现，以等级最高的为准
				if (!privileges.containsKey(p.name) || privileges.get(p.name) < p.level) {
					privileges.put(p.name, p.level);
				}
			}
			roles.put(role, privileges);
		}

		// 存储所有用户及其具有的所有权限
		Map<String, Map<String, Integer>> users = new HashMap<>();
		int userCount = scan.nextInt();
		for (int i = 0; i < userCount; i++) {
			String user = scan.next();

			// 存储用户user及其具有的所有权限
			Map<String, Integer> privileges = new HashMap<>();
			int t = scan.nextInt();
			for (int j = 0; j < t; j++) {
				String role = scan.next();
				roles.get(role).forEach((privilegeName, level) -> {
					// 若user尚不具有privilegeName该类权限，或者user具有的权限等级低于level
					if (!privileges.containsKey(privilegeName) || privileges.get(privilegeName) < level) {
						privileges.put(privilegeName, level);
					}
				});
				users.put(user, privileges);
			}
		}

		// 权限查询
		StringBuilder sb = new StringBuilder();
		int queryCount = scan.nextInt();
		for (int i = 0; i < queryCount; i++) {
			String user = scan.next();
			Privilege p = split(scan.next());

			// 如果用户不存在，或者用户不具有该类权限，或者用户该类权限的等级不够
			Map<String, Integer> privileges = users.get(user);
			if (privileges == null || !privileges.containsKey(p.name) || privileges.get(p.name) < p.level) {
				sb.append("false");
			} else if (p.level == -1 && privileges.get(p.name) != -1) {
				// 若为分等级权限的不带等级查询，则输出用户具有该权限的最高等级
				sb.append(privileges.get(p.name));
			} else {
				sb.append("true");
			}
			sb.append('\n');
		}

		scan.close();
		System.out.println(sb.toString());
	}

	// 按照冒号:分割权限字符串，得到权限等级level。若权限字符串中不包含等级，则level设为-1
	public static Privilege split(String name) {
		int level = -1;
		int index = name.indexOf(":");
		if (index >= 0) {
			level = Integer.parseInt(name.substring(index + 1));
			name = name.substring(0, index);
		}
		return new Privilege(name, level);
	}
}
