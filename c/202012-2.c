#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct _element {
	int y;
	int result;
} element;

int cmp(const void *a, const void *b) 
{
	element *i = (element *)a;
	element *j = (element *)b;
	return i->y - j->y;
}

int main(int argc, char const *argv[])
{
	int i, m, yi, result, correct_count;

	scanf("%d", &m);
	element arr[m];
	for (i = 0; i < m; i++)
	{
		scanf("%d %d", &yi, &result);
		element e = {yi, result};
		arr[i] = e;
	}
	// 按照安全系统y升序排序
	qsort((void *)arr, m, sizeof(element), cmp);

	// 统计真阳（不挂科），使用后缀和
	int success[m];
	for (i = m - 1; i >= 0; i--)
	{
		if (i == m - 1) {
			success[i] = arr[i].result;
		} else {
			success[i] = success[i + 1] + arr[i].result;
		}
	}

	// 统计假阴（挂科），使用前缀和
	int error[m];
	// 当连续多个安全系数相等时，统计其中挂科的人数
	int error_count = 0;
	for (i = 0; i < m; i++)
	{
		if (i == 0) {
			error[i] = 0;
		} else if (arr[i - 1].y == arr[i].y) {
			error[i] = error[i - 1];
			error_count += !arr[i - 1].result;
		} else {
			error[i] = error_count + error[i - 1]  + !arr[i - 1].result;
			error_count = 0;
		}
	}

	// 寻找最高的准确率
	int max_count = INT_MIN;
	for (i = 0; i < m; i++)
	{
		correct_count = success[i] + error[i];
		if (correct_count > max_count)
		{
			max_count = correct_count;
		}
	}

	// 根据最高准确率，寻找最佳阈值（值最大）
	int max_y = INT_MIN;
	for (i = 0; i < m; i++)
	{
		correct_count = success[i] + error[i];
		if (correct_count == max_count)
		{
			if (arr[i].y > max_y)
			 {
			 	max_y = arr[i].y;
			 } 
		}
	}

	printf("%d\n", max_y);
	return 0;
}