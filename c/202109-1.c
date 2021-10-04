#include <stdio.h>

#define MAX 100001

int main(int argc, char const *argv[])
{
	int n;
	scanf("%d", &n);

	int i, cur;
	int arr[MAX] = {0};
	int min_sum, max_sum;

	min_sum = max_sum = 0;
	for (i = 0; i < n; i++) {
		scanf("%d", &cur);
		if (!arr[cur]) {
			min_sum += cur;
			arr[cur] = 1;
		}
		max_sum += cur;
	}

	printf("%d\n", max_sum);
	printf("%d\n", min_sum);
	return 0;
}