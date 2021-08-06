# 将输入的行转换为int型数组 
def str_to_int_arr(line):
	arr = line.split(' ')
	return map(int, arr)


def main():
	m, n, L = str_to_int_arr(input())
	A = [0] * L
	for i in range(m):
		arr = str_to_int_arr(input())
		for j, x in enumerate(arr):
			A[x] += 1

	print(' '.join(map(str, A)))


if __name__ == '__main__':
	main()