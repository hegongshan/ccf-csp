#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
	int m, n, L;
	scanf("%d %d %d", &m, &n, &L);

	int i, j, x;
	int A[L];
	memset(A, 0, sizeof(A));

	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			scanf("%d", &x);
			A[x]++;
		}
	}

	for (i = 0; i < L; i++)
	{
		if (i > 0)
		{
			putchar(' ');
		}
		printf("%d", A[i]);
	}
	putchar('\n');
	return 0;
}