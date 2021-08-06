def main():
	n, L, r, t = map(int, input().split(' '))

	gray_sum = []
	for i in range(n):
		gray_sum.append([])
		A_i = input().split(' ')

		for j, A_ij in enumerate(A_i):
			if j == 0:
				gray_sum[i].append(int(A_ij))
			else:
				gray_sum[i].append(gray_sum[i][j - 1] + int(A_ij))

	gray_area_count = 0
	for i in range(n):
		for j in range(n):
			sum_of_gray = 0
			min_x_r = 0 if i - r < 0 else i - r
			max_x_r = n - 1 if i + r >= n else i + r

			min_y_r = 0 if j - r < 0 else j - r
			max_y_r = n - 1 if j + r >= n else j + r

			num_r = (max_x_r - min_x_r + 1) * (max_y_r - min_y_r + 1)
			upper_limit = num_r * t

			for k in range(min_x_r, max_x_r + 1):
				if min_y_r == 0:
					sum_of_gray += gray_sum[k][max_y_r]
				else:
					sum_of_gray += gray_sum[k][max_y_r] - gray_sum[k][min_y_r - 1]
				# 优化
				if sum_of_gray > upper_limit:
					break
			if sum_of_gray <= upper_limit:
				gray_area_count += 1
	print(gray_area_count)


if __name__ == '__main__':
	main()