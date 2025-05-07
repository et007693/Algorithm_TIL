import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
psum = [[0] * (n + 1) for _ in range(n + 1)]

for x in range(1, n+1):
    for y in range(1, n+1):
        psum[x][y] = arr[x-1][y-1] + psum[x-1][y] + psum[x][y-1] - psum[x-1][y-1]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())

    result = psum[x2][y2] - psum[x1-1][y2] - psum[x2][y1-1]+ psum[x1-1][y1-1]
    print(result)