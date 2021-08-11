def main():
	n = int(input())

	num = 4
	cur = 1
	count_list = [0] * num
	while n > 0:
		if cur % 7 == 0 or str(cur).find('7') >= 0:
			count_list[(cur - 1) % num] += 1
			cur += 1
			continue
		n -= 1
		cur += 1
	print('\n'.join(map(str, count_list)))

if __name__ == '__main__':
	main()