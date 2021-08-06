import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数字排序
 * @author hegongshan　https://www.hegongshan.com
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		List<Node<Integer>> list = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			Integer number = scan.nextInt();
			boolean flag = false;
			Node<Integer> node;
			// 若已存在，则频度加1
			for (int j = 0; j < list.size(); j++) {
				node = list.get(j);
				if(node.data.equals(number)) {
					node.frequency += 1;
					flag = true;
					break;
				}
			}
			//若数字不存在，将其添加到list，并将频度初始化为１
			if(!flag) {
				node = new Node<>(number,1);
				list.add(node);
			}
		}
		scan.close();
		
		list.sort((Node<Integer> a,Node<Integer> b)->{
			if(a.frequency < b.frequency ) {
				return 1;
			} else if(a.frequency == b.frequency) {
				if(a.data < b.data) {
					return -1;
				} else if(a.data == b.data) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return -1;
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			Node<Integer> node = list.get(i);
			System.out.println(node.data + " " + node.frequency);
		}
	}
	
	private static class Node<T> {
		T data;
		//频度
		int frequency;
		Node(T data, int frequency) {
			super();
			this.data = data;
			this.frequency = frequency;
		}
	}
}

