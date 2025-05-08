import sys
input = sys.stdin.readline

n, k = map(int, input().split())
back = [[0,0]] + [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * (k+1) for _ in range(n+1)]

for i in range(1, n+1): # 물건 갯수
    for j in range(1, k+1): # 무게
        weight = back[i][0]
        value = back[i][1]

        if weight > j: # 현재 물건의 무게가 남아있는 무게보다 클 때
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight] + value) # 물건을 넣지 않은 것과, 넣은 것의 가치 중 더 큰 값으로 저장

print(dp[n][k])