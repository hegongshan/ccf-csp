package com.hegongshan.ccfcsp.t2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T20161203 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//存储权限
		int categoryCount = Integer.parseInt(scan.nextLine());
		List<Privilege> privileges = new ArrayList<>();
		for (int i = 0; i < categoryCount; i++) {
			String str = scan.nextLine();
			String name;
			Integer level;
			if(str.contains(":")) {
				String[] sArr = str.split(":");
				name = sArr[0];
				level = Integer.parseInt(sArr[1]);
			} else {
				name = str;level = -1;
			}
			Privilege privilege = new Privilege(name,level);
			privileges.add(privilege);
		}
		//存储角色
		int roleCount = Integer.parseInt(scan.nextLine());
		List<Role> roles = new ArrayList<>();
		for (int i = 0; i < roleCount; i++) {
			String[] sArr = scan.nextLine().split(" ");
			Role role = new Role();
			role.setName(sArr[0]);
			List<Privilege> privileges2 = new ArrayList<>();
			for (int j = 0; j < Integer.parseInt(sArr[1]); j++) {
				Privilege privilege = null;
				if(sArr[j+2].contains(":")) {
					String[] arr = sArr[j+2].split(":");
					privilege = new Privilege(arr[0],Integer.parseInt(arr[1]));
				} else {
					privilege = new Privilege(sArr[j+2],-1);
				}
				privileges2.add(privilege);
			}
			role.setPrivileges(privileges2);
			roles.add(role);
		}
		
		//存储用户
		int userCount = Integer.parseInt(scan.nextLine());
		List<User> users = new ArrayList<>();
		for (int i = 0; i < userCount; i++) {
			String[] sArr = scan.nextLine().split(" ");
			User user = new User();
			user.setName(sArr[0]);
			List<Role> roles2 = new ArrayList<>();
			for (int j = 0; j < Integer.parseInt(sArr[1]); j++) {
				Role role = new Role();
				String name = sArr[j+2];
				for (int k = 0; k < roles.size(); k++) {
					if(roles.get(k).getName().equals(name)) {
						role.setPrivileges(roles.get(k).getPrivileges());
						break;
					}
				}
				roles2.add(role);
			}
			user.setRoles(roles2);
			users.add(user);
		}
		
		//查询
		StringBuilder out = new StringBuilder();
		int queyCount = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < queyCount; i++) {
			String[] sArr = scan.nextLine().split(" ");
			boolean exist = false;
			for (int j = 0; j < users.size(); j++) {
				User user = users.get(j);
				//若存在该用户
				if(user.getName().equals(sArr[0])) {
					exist = true;
					//如果查询的权限带等级
					if(sArr[1].contains(":")) {
						String[] sArr2 = sArr[1].split(":");
						String privilegeName = sArr2[0];
						boolean flag = false;
						outerLoop:for (int l = 0; l < user.getRoles().size(); l++) {
							List<Privilege> tempPrivileges = user.getRoles().get(l).getPrivileges();
							for (int l2 = 0; l2 < tempPrivileges.size(); l2++) {
								Privilege tempPrivilege = tempPrivileges.get(l2);
								if(tempPrivilege.getName().equals(privilegeName) && tempPrivilege.getLevel()>=Integer.valueOf(sArr2[1])) {
									flag = true;
									break outerLoop;
								}
							}
						}
						out.append(flag).append("\n");
					} else {//不带等级查询
						String name = sArr[1];
						boolean flag = false;
						int maxLevel = 0;
						for (int l = 0; l < user.getRoles().size(); l++) {
							List<Privilege> tempPrivileges = user.getRoles().get(l).getPrivileges();
							for (int l2 = 0; l2 < tempPrivileges.size(); l2++) {
								Privilege tempPrivilege = tempPrivileges.get(l2);
								if(tempPrivilege.getName().equals(name)) {
									flag = true;
									maxLevel = tempPrivilege.getLevel();
								}
							}
						}
						if(!flag) {
							out.append(flag);
						} else {
							//若为分等级的权限
							if(maxLevel != -1) {
								out.append(maxLevel);
							} else {
								out.append(flag);
							}
						}
						out.append("\n");
					}
					break;
				} 
			}
			if(!exist) {
				out.append(exist).append("\n");
			}
		}
		
		scan.close();
		System.out.println(out);
	}
}
class Privilege{
	String name;
	Integer level;
	public Privilege(String name, Integer level) {
		super();
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}
class Role{
	String name;
	List<Privilege> privileges;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}
class User{
	String name;
	List<Role> roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
