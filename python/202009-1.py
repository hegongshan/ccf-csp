def main():
	n, x, y = map(int, input().split(' '))
	arr = []
	for i in range(1, n + 1):
		loc = list(map(int, input().split(' ')))
		dist = (loc[0] - x) ** 2 + (loc[1] - y) ** 2
		arr.append([i, dist])

	# 首先按距离升学排序，当距离相等时，按照监测点编号升序排序
	res = sorted(arr, key=lambda x: (x[1], x[0]))[:3]
	for i in range(3):
		print(res[i][0])


if __name__ == '__main__':
	main()