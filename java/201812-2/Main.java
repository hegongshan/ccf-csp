import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] light = new int[3];
		//红，黄，绿
		for(int i=0;i<light.length;i++) {
			light[i] = scan.nextInt();
		}
		int n = scan.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0;i<arr.length;i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		long time = 0;
		for(int i=0;i<arr.length;i++) {
			//如果是道路
			if(arr[i][0] == 0) {
				time += arr[i][1];
			} else {
				long[][] data = calculate(light,arr[i][0],arr[i][1],time);
				//1-红灯，2-黄灯，3-绿灯 红->绿->黄->红
				if(data[0][0] == 1) {
					time += data[0][1];
				} else if(data[0][0] == 2) {
					time += data[0][1] + light[0];
				}
			}
			System.out.println(time);
		}
		System.out.println(time);
	}
	//计算当小明走到该红黄绿路灯时，它当前的状态及其持续时间
	public static long[][] calculate(int[] light,int state, long duration,long time) {
		long[][] result = new long[1][2];
		int sum = 0;
		for(int i=0;i<light.length;i++) {
			sum += light[i];
		}
		if(duration > time) {
			result[0][0] = state;
			result[0][1] = duration;
		} else {
			long r = (time - duration) % sum;
			if(state == 1) {
				if(r <= light[2]) {
					result[0][0] = 3;
					result[0][1] = light[2] - r;
				} else if(r <= light[2]+light[1]) {
					result[0][0] = 2;
					result[0][1] = light[2]+light[1] - r;
				} else if(r <= light[0]+light[1]+light[2]) {
					result[0][0] = 1;
					result[0][1] = sum - r;
				}
			} else if(state == 2) {
				if(r <= light[0]) {
					result[0][0] = 1;
					result[0][1] = light[0]-r;
				} else if(r <= light[0]+light[2]) {
					result[0][0] = 3;
					result[0][1] = light[0]+light[2] - r;
				} else if(r <= light[0]+light[2]+light[1]) {
					result[0][0] = 2;
					result[0][1] = sum -r ;
				}
			} else {
				if(r <= light[1]) {
					result[0][0] = 2;
					result[0][1] = light[1] - r;
				} else if(r <= light[1]+light[0]) {
					result[0][0] = 1;
					result[0][1] = light[1] +light[0]-r;
				} else if(r <= light[1]+light[0]+light[2]) {
					result[0][0] = 3;
					result[0][1] = sum-r;
				}
			}
		}
		return result;
		
	}
}
