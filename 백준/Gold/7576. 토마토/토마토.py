from collections import deque
result = 0
m, n = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]
q = deque()

for y in range(n):
    for x in range(m):
        if arr[y][x] == 1:
            q.append([x, y])

def dfs():
    while q:
        x, y = q.popleft()
        for dx, dy in ([0, 1], [0, -1], [1, 0], [-1, 0]):
            mx = x + dx
            my = y + dy
            if 0 <= mx < m and 0 <= my < n and arr[my][mx] == 0:
                arr[my][mx] = arr[y][x] + 1
                q.append([mx, my])
dfs()

if any(0 in row for row in arr):
    print(-1)
else:
    print(max(map(max, arr))-1)