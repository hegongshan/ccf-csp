def main():
	n = int(input())

	score = 0
	for i in range(n):
		arr = input().split(' ')
		w_i, score_i = int(arr[0]), int(arr[1])
		score += w_i * score_i
	score = max(0, score)
	print(score)

if __name__ == '__main__':
	main()