def main():
	n, m = map(int, input().split(' '))

	t = 0
	apples = []
	for i in range(1, n + 1):
		arr = list(map(int, input().split(' ')))
		drop_count = -sum(arr[1:])
		apples.append([i, drop_count])
		t += arr[0] - drop_count;
	
	res = sorted(apples, key=lambda x: (x[1], -x[0]), reverse=True)[0]
	print('%d %d %d' % (t, res[0], res[1]))


if __name__ == '__main__':
	main()