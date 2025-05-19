n = int(input())
nums = list(map(int, input().split()))
nums.sort()
x = int(input())

result = 0
s, e = 0, n-1

while s < e:
    tmp = nums[s] + nums[e]
    if tmp == x:
        result += 1
        s += 1
    elif tmp > x:
        e -=1 
    else:
        s += 1

print(result)