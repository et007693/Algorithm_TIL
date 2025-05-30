n = int(input())
nums_list = [int(input()) for _ in range(n)]
max_num = max(nums_list)

dp = [0] * (max_num + 1)
dp[0] = 1

for num in [1, 2, 3]:
    for i in range(num, max_num + 1):
        dp[i] += dp[i - num]

for nums in nums_list:
    print(dp[nums])