import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 出现次数最多的数
 * @author hegongshan https://www.hegongshan.com
 *
 */
public class Main {
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<Integer,Integer> map = new HashMap<>();
		int total = scan.nextInt();
		for(int i=0;i<total;i++) {
			int num = scan.nextInt();
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		scan.close();
		int data = 0;
		int maxCount = 0;
		Iterator<Entry<Integer,Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer,Integer> entry = iter.next();
			if(entry.getValue() > maxCount) {
				data = entry.getKey();
				maxCount = entry.getValue();
			} else if(entry.getValue() == maxCount && entry.getKey() < data) {
				data = entry.getKey();
			}
		}
		System.out.println(data);
	}
}
