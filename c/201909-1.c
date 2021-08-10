#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Apple
{
	int no;
	int origin_count;
	int drop_count;
} Apple;

int cmp(const void *a, const void *b)
{
	Apple *x = (Apple *)a;
	Apple *y = (Apple *)b;
	if (x->drop_count != y->drop_count)
	{
		return y->drop_count - x->drop_count;
	}
	return x->no - y->no;
}

int main(int argc, char const *argv[])
{
	int n, m;
	scanf("%d %d", &n, &m);

	int i, j, t = 0;
	int aj;
	Apple apple[n];

	for (i = 0; i < n; i++)
	{
		apple[i].no = i + 1;
		apple[i].drop_count = 0;
		scanf("%d", &apple[i].origin_count);

		for (j = 0; j < m; j++)
		{
			scanf("%d", &aj);
			apple[i].drop_count += aj;
		}
		apple[i].drop_count = -apple[i].drop_count;

		t += apple[i].origin_count - apple[i].drop_count;
	}

	qsort(apple, n, sizeof(Apple), cmp);
	printf("%d %d %d\n", t, apple[0].no, apple[0].drop_count);
	return 0;
}