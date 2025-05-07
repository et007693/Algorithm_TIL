n, k = map(int, input().split())
medal = [list(map(int, input().split())) for _ in range(n)]

medal.sort(key=lambda x: (-x[1], -x[2], -x[3]))
    
ranks = dict()
rank = 1
prev = medal[0][1:]
ranks[medal[0][0]] = rank

for i in range(1, n):
    curr = medal[i][1:]
    if curr == prev:
        ranks[medal[i][0]] = rank
    else:
        rank = i + 1
        ranks[medal[i][0]] = rank
        prev = curr

print(ranks[k])