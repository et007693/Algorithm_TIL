from collections import deque

n, k = map(int, input().split())
arr = [1e10] * 100001
arr[n] = 0
q = deque([n])

while q:
    s = q.popleft()

    for next in (s-1, s+1, 2*s):
        if next > 100000 or next < 0:
            continue
        if arr[next] > arr[s] + 1:
            if next == 2*s:
                arr[next] = arr[s]
            else:
                arr[next] = arr[s] + 1
            q.append(next)
print(arr[k])