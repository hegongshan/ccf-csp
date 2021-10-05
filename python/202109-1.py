"""
数组推导
@author: hegongshan
@date: 2021-10-05
"""

def main():
	min_sum = 0
	max_sum = 0
	num_set = set()

	n = int(input())
	b_arr = map(int, input().split(' '))
	for bi in b_arr:
		if bi not in num_set:
			num_set.add(bi)
			min_sum += bi
		max_sum += bi
	print(max_sum, min_sum, sep='\n')



if __name__ == '__main__':
	main()