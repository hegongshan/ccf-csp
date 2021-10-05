#include <stdio.h>

int main(int argc, char const *argv[])
{
	int n;
	scanf("%d", &n);

	int i, arr[n];
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	// 处理最大值和最小值
	int min, max;
	float mid;
	if (arr[0] > arr[n - 1]) {
		max = arr[0];
		min = arr[n - 1];
	} else {
		max = arr[n - 1];
		min = arr[0];
	}

	// 处理中位数
	int mid_idx = n >> 1;
	if (n & 0x1) {
		mid = arr[mid_idx];
	} else {
		mid = (arr[mid_idx - 1] + arr[mid_idx]) / 2.0;
	}

	printf("%d ", max);
	if (mid == (int) mid) {
		printf("%d ", (int)mid);
	} else {
		printf("%.1f ", mid);
	}
	printf("%d\n", min);
	return 0;
}