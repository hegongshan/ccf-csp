#include <stdio.h>
#include <stdlib.h>

typedef struct Point
{
	int no; // 检测点编号
	int dist;	
} Point;

int cmp(const void *a, const void *b)
{
	Point *p1 = (Point *)a;
	Point *p2 = (Point *)b;
	if (p1->dist != p2->dist)
	{
		return p1->dist - p2->dist;
	}
	return p1->no - p2->no;
}

int main(int argc, char const *argv[])
{
	int n, x, y;
	scanf("%d %d %d", &n, &x, &y);

	Point arr[n];
	int i, xi, yi, disti;
	for (i = 0; i < n; i++)
	{
		scanf("%d %d", &xi, &yi);
		disti = (xi - x) * (xi - x) + (yi - y) * (yi - y);
		Point pi = {i + 1, disti};
		arr[i] = pi;
	}

	qsort(arr, n, sizeof(Point), cmp);
	for (i = 0; i < 3; i++)
	{
		printf("%d\n", arr[i].no);
	}
	return 0;
}