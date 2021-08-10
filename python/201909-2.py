def main():
	n = int(input())

	t, e = 0, 0
	d = [0] * n
	for i in range(n):
		arr = list(map(int, input().split(' ')))
		m, a1 = arr[0], arr[1]
		for j in range(2, m + 1):
			if 0 < arr[j] < a1:
				# 掉落
				a1 = arr[j]
				d[i] = 1
			elif arr[j] <= 0:
				# 疏果
				a1 += arr[j]
		t += a1

	for i in range(n):
		if d[(i - 1 + n) % n] == d[i] == d[(i + 1 + n) % n] == 1:
			e += 1

	print('%d %d %d' % (t, sum(d), e))
			


if __name__ == '__main__':
	main()