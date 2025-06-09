from collections import deque

s = input()
t = input()
q = deque([t])
result = 0

while q:
    string = q.popleft()

    if string == s:
        result = 1
        break
    
    if len(string) > 1:
        if string[-1] == "A":
            q.append(string[:-1])
        if string[0] == "B":
            q.append(string[::-1][:-1])

print(result)