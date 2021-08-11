#include <stdio.h>
#include <string.h>

#define NUM 4

int isskip(int x) 
{
	if (x % 7 == 0)
	{
		return 1;
	}
	while (x > 0)
	{
		if (x % 10 == 7)
		{
			return 1;
		}
		x /= 10;
	}
	return 0;
}


int main(int argc, char const *argv[])
{
	int n;
	scanf("%d", &n);

	// 当前报数
	int cur = 1;
	// 存储跳过次数
	int count[NUM];
	memset(count, 0, sizeof(count));
	while (n > 0) 
	{
		if (isskip(cur))
		{
			count[(cur - 1) % NUM] += 1;
			cur ++;
			continue;
		}
		cur ++;
		n --;
	}

	// 输出统计结果
	int i;
	for (i = 0; i < NUM; i++)
	{
		printf("%d\n", count[i]);
	}
	return 0;
}