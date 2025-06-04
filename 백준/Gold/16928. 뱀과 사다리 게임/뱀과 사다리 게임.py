from collections import deque

n, m = map(int, input().split())

ladder = {x: y for x, y in (map(int, input().split()) for _ in range(n))}
snake = {x: y for x, y in (map(int, input().split()) for _ in range(m))}

arr = [1e10] * 101
arr[1] = 0

q = deque([1])
while q:
    start = q.popleft()

    for i in range(1, 7):
        end = start + i
        if end > 100:
            continue

        next_pos = ladder.get(end, snake.get(end, end))
        if arr[next_pos] > arr[start] + 1:
            arr[next_pos] = arr[start] + 1
            q.append(next_pos)

print(arr[100])