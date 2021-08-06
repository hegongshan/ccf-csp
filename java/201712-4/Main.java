import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] visited = new int[n];
		for(int i=0;i<n;i++) {
			visited[i] = -1;
		}
		List<RoadDetail> list = new ArrayList<>();
		for(int i=0;i<m;i++) {
			boolean isBigRoad = scan.nextInt() == 1 ? false : true;
			int start = scan.nextInt();
			int end = scan.nextInt();
			int length = scan.nextInt();
			RoadDetail r = new RoadDetail(isBigRoad,start,end,length);
			list.add(r);
		}
		scan.close();
		
		int result = 0;
		boolean isSmallRoad = false;
		int sum = 0;
		for(int i=1;i<n;i++) {
			for(int j=0;j<list.size();j++) {
				RoadDetail r = list.get(j);	
				if(visited[r.start-1] == 1) {
					continue;
				}
				if(r.start == i && r.end == i+1) {
					if(r.isBigRoad) {
						result += r.length;
						isSmallRoad = false;
					} else {
						isSmallRoad = true;
						sum += r.length;
					}
					break;
				}
			}
			if(!isSmallRoad) {
				result += Math.pow(sum, 2);
				sum = 0;
			}
		}
		if(isSmallRoad) {
			result += Math.pow(sum, 2);
		}
		System.out.println(result);
	}

	static class RoadDetail {
		boolean isBigRoad;
		int start;
		int end;
		int length;
		public RoadDetail(boolean isBigRoad, int start, int end, int length) {
			super();
			this.isBigRoad = isBigRoad;
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}
}
