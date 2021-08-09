def main():
	n, x, y = map(int, input().split(' '))
	arr = []
	for i in range(1, n + 1):
		xi, yi = list(map(int, input().split(' ')))
		dist = (xi - x) ** 2 + (yi - y) ** 2
		arr.append([i, dist])

	# 首先按距离升序排序，当距离相等时，按照检测点编号升序排序
	res = sorted(arr, key=lambda x: (x[1], x[0]))[:3]
	for i in range(3):
		print(res[i][0])


if __name__ == '__main__':
	main()