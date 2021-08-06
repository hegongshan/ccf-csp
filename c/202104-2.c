#include <stdio.h>

int main(int argc, char const *argv[])
{
	int n, L, r, t;
	scanf("%d %d %d %d", &n, &L, &r, &t);

	int gray_sum[n][n];
	int i, j, k, x;
	for (i = 0; i < n; i++) 
	{
		for (j = 0; j < n; j++)
		{
			scanf("%d", &x);
			if (j == 0)
				gray_sum[i][j] = x;
			else
				gray_sum[i][j] = gray_sum[i][j - 1] + x;
		}
	}

	int gray_area_count = 0;
	int sum_of_gray, num_r, upper_limit;
	int min_x_r, max_x_r, min_y_r, max_y_r;
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		{

			sum_of_gray = 0;
			min_x_r = i - r < 0 ? 0 : i - r;
			max_x_r = i + r >= n ? n - 1 : i + r;

			min_y_r = j - r < 0 ? 0 : j - r;
			max_y_r = j + r >= n ? n - 1 : j + r;

			num_r = (max_x_r - min_x_r + 1) * (max_y_r - min_y_r + 1);
			upper_limit = num_r * t;

			for (k = min_x_r; k <= max_x_r; k++)
			{
				if (min_y_r == 0)
					sum_of_gray += gray_sum[k][max_y_r];
				else
					sum_of_gray += gray_sum[k][max_y_r] - gray_sum[k][min_y_r - 1];

				if (sum_of_gray > upper_limit)
					break;
			}
			if (sum_of_gray <= upper_limit)
				gray_area_count += 1;
		}
	}
	printf("%d\n", gray_area_count);

	return 0;
}
	