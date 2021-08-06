import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Role {
		int attack;
		int health;

		public Role(int attack, int health) {
			this.attack = attack;
			this.health = health;
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		@SuppressWarnings("unchecked")
		List<Role>[] players = new ArrayList[2];
		for (int i = 0; i < players.length; i++) {
			players[i] = new ArrayList<>();
			players[i].add(new Role(0, 30));
		}

		// 当前玩家
		int current = 0;
		// 对手
		int rival = 1;
		for (int i = 0; i < n; i++) {
			String operation = scan.next();
			
			// 结束该回合，攻守双方互换
			if (operation.equals("end")) {
				rival = current;
				current = 1 - current;
				continue;
			}
			
			// 召唤随从
			if (operation.equals("summon")) {
				int position = scan.nextInt();
				players[current].add(position, new Role(scan.nextInt(), scan.nextInt()));
				continue;
			}
			
			// 随从攻击
			if (operation.equals("attack")) {
				int attacker = scan.nextInt();
				int defender = scan.nextInt();
				// 模拟攻击操作
				players[current].get(attacker).health -= players[rival].get(defender).attack;
				players[rival].get(defender).health -= players[current].get(attacker).attack;
				// 若attacker已死亡，则从当前玩家的随从列表中删除
				if (players[current].get(attacker).health <= 0) {
					players[current].remove(attacker);
				}
				// 若defender是随从且已死亡，则从对手的随从列表中删除
				if (players[rival].get(defender).health <= 0 && defender != 0) {
					players[rival].remove(defender);
				}
			}
		}
		scan.close();

		StringBuilder sb = new StringBuilder();
		// 判断游戏的胜负结果
		if (players[1].get(0).health <= 0) {
			sb.append(1);
		} else if (players[0].get(0).health <= 0) {
			sb.append(-1);
		} else {
			sb.append(0);
		}
		sb.append('\n');

		for (List<Role> player : players) {
			// 玩家英雄的生命值
			sb.append(player.get(0).health).append('\n');
			// 玩家在战场上存活的随从个数、各随从剩余生命值
			sb.append(player.size() - 1);
			for (int i = 1; i < player.size(); i++) {
				sb.append(' ').append(player.get(i).health);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
