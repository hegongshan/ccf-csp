#include <stdio.h>

int main(int argc, char const *argv[])
{
	int n;
	scanf("%d", &n);

	int score = 0;
	int i, wi, scorei;
	for (i = 0; i < n; i++) 
	{
		scanf("%d %d", &wi, &scorei);
		score += wi * scorei;
	}

	score = score > 0 ? score : 0;
	printf("%d\n", score);
	return 0;
}
