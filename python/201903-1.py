"""
小中大 http://118.190.20.162/view.page?gpid=T89
@author: hegongshan
@date: 2021-10-05
"""

def main():
	n = int(input())
	arr = list(map(int, input().split(' ')))

	# 处理最大值和最小值
	if arr[0] > arr[n - 1]:
		max_val = arr[0]
		min_val = arr[n - 1]
	else:
		max_val = arr[n - 1]
		min_val = arr[0]

	# 处理中位数
	mid_idx = n >> 1
	if n & 0x1 == 1:
		mid_val = arr[mid_idx]
	else:
		mid_val = (arr[mid_idx - 1] + arr[mid_idx]) / 2.0

	print(max_val, end=' ')
	if mid_val == int(mid_val):
		print("%d" % int(mid_val), end=' ')
	else:
		print('%.1f' % mid_val, end=' ')
	print(min_val)


if __name__ == '__main__':
	main()