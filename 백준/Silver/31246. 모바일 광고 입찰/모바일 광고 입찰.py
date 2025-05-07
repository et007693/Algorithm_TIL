import sys
input = sys.stdin.readline

n, k = map(int, input().split())
diff = []

for _ in range(n):
    i, j = map(int, input().split())
    diff.append(j-i)

diff.sort()

if diff[k-1] < 0:
    print(0)
else:
    print(diff[k-1])