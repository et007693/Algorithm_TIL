n = int(input())
top = list(map(int, input().split()))
stack = []
result = [0] * n

for i in range(n):
    while stack:
        if stack[-1][1] > top[i]:
            result[i] = stack[-1][0] + 1
            break
        else:
            stack.pop()
    stack.append((i, top[i]))
print(*result)