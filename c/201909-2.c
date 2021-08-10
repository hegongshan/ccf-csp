#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
	int t = 0, d_count = 0, e = 0;

	int n, m, i, j;
	scanf("%d", &n);

	int d[n];
	memset(d, 0, n * sizeof(int));

	int a1, aj;
	for (i = 0; i < n; i++)
	{
		scanf("%d %d", &m, &a1);
		for (j = 2; j <= m; j++)
		{
			scanf("%d", &aj);
			if (0 < aj && aj < a1)
			{
				// 掉落
				a1 = aj;
				d[i] = 1;
			}
			else if (aj <= 0) 
			{
				// 疏果
				a1 += aj;
			}
		}
		t += a1;
	}

	for (i = 0; i < n; i++)
	{
		d_count += d[i];
		if (d[i] == 1 && d[(i - 1 + n) % n] == d[i] && d[i] == d[(i + 1 + n) % n])
		{
			e ++;
		}
	}
	printf("%d %d %d\n", t, d_count, e);
	return 0;
}