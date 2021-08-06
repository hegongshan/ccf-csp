import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Transaction implements Comparable<Transaction> {
		// 交易类型，0-buy,1-sell,2-cancel
		int type;
		// 出价
		double price;
		// 交易的股数
		long amount;
		// 交易是否被取消
		boolean cancel;

		@Override
		public int compareTo(Transaction o) {
			if (this.price > o.price) {
				return 1;
			}
			if (this.price == o.price) {
				return 0;
			}
			return -1;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Transaction> list = new ArrayList<>();
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] sArr = line.split(" ");
			Transaction t = new Transaction();

			// 若为撤销
			if ("cancel".equals(sArr[0])) {
				t.type = 2;
				t.cancel = true;
				list.add(t);

				// 撤销第index行的交易记录
				int index = Integer.parseInt(sArr[1]);
				list.get(index - 1).cancel = true;
				continue;
			}

			// 若为买单
			if ("buy".equals(sArr[0])) {
				t.type = 0;
			} else { // 若为卖单
				t.type = 1;
			}
			t.price = Float.parseFloat(sArr[1]);
			t.amount = Long.parseLong(sArr[2]);
			list.add(t);
		}
		scan.close();

		// 分割为买单和卖单
		List<Transaction> buys = new ArrayList<>(list.size());
		List<Transaction> sells = new ArrayList<>(list.size());
		for (Transaction t : list) {
			// 忽略被撤销的交易记录（或者撤销命令本身）
			if (t.cancel) {
				continue;
			}
			if (t.type == 0) {
				buys.add(t);
			} else {
				sells.add(t);
			}
		}

		// 按照价格从小到大排序
		Collections.sort(buys);
		Collections.sort(sells);

		long maxAmount = 0L;
		double price = 0d;
		for (int i = 0; i < buys.size(); i++) {
			Transaction t = buys.get(i);
			long buyAmount = 0L, sellAmount = 0L;
			for (int j = i; j < buys.size(); j++) {
				buyAmount += buys.get(j).amount;
			}
			for (Transaction t2 : sells) {
				// 出价最多为t.price
				if (t2.price > t.price) {
					break;
				}
				sellAmount += t2.amount;
			}
			long dealAmount = Math.min(buyAmount, sellAmount);
			// 选择最大的成交量；若成交量相等，则选择最高的开盘价
			if (maxAmount < dealAmount || (maxAmount == dealAmount && price < t.price)) {
				maxAmount = dealAmount;
				price = t.price;
			}
		}

		System.out.printf("%.2f %d\n", price, maxAmount);
	}

}
