import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException {
		// 读入的字符数量过大，使用Scanner会超时
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		int n = Integer.parseInt(sArr[0]);
		int s = Integer.parseInt(sArr[1]);
		int l = Integer.parseInt(sArr[2]);

		Map<Integer, String> disks = new HashMap<>();

		for (int i = 0; i < l; i++) {
			String[] sArr2 = br.readLine().split(" ");
			int index = Integer.parseInt(sArr2[0]);
			String content = sArr2[1];
			disks.put(index, content);
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			// 读取的块编号
			int b = Integer.parseInt(br.readLine());
			// 块b所在的条带编号
			int band = b / s;
			// 块b所在的磁盘编号（编号从0开始）
			int diskId = band % n;
			// 条带band，在磁盘diskId上的条带编号（编号从0开始）
			int k = band / (n - 1);
			// 块b，在磁盘diskId上的块号（编号从0开始）
			int block = k * s + b % s;

			// 1.被读取的块所在的硬盘缺失，且该数据无法由现存的硬盘数据推算出来;指定的块超出阵列总长度。
			if ((block + 1) * 8 > disks.get(diskId).length() || (!disks.containsKey(diskId) && n - l > 1)) {
				System.out.println('-');
				continue;
			}
			// 2.磁盘数据完好
			if (disks.containsKey(diskId)) {
				System.out.println(disks.get(diskId).substring(8 * block, 8 * (block + 1)));
				continue;
			}
			// 3.磁盘数据缺失，但可以由现存的磁盘数据推算出来
			int result = 0;
			boolean flag = false;
			for (Entry<Integer, String> entry : disks.entrySet()) {
				String str = entry.getValue().substring(8 * block, 8 * (block + 1));
				if (!flag) {
					result = Integer.parseInt(str, 16);
					flag = true;
				} else {
					result ^= Integer.parseInt(str, 16);
				}
			}
			System.out.printf("%08X\n", result);
		}

		br.close();
	}

}
