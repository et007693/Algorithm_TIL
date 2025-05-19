from collections import Counter

a = Counter(list(input()))
b = Counter(list(input()))

result = 0

for char in set(a.keys()).union(b.keys()):
    result += abs(a[char] - b[char])

print(result)