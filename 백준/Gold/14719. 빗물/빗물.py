h, w = map(int, input().split())
height = list(map(int, input().split()))

left, right = 0, w - 1
left_max, right_max = height[left], height[right]
result = 0

while left < right:
    if left_max < right_max:
        left += 1
        left_max = max(left_max, height[left])
        result += max(0, left_max - height[left])
    else:
        right -= 1
        right_max = max(right_max, height[right])
        result += max(0, right_max - height[right])

print(result)
