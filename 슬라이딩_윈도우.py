# 슬라이딩 윈도우 : 범위합에서 왼쪽 끝을 빼고 오른쪽 끝을 더하는 것
result = [sum(nums[:k])]

for i in range(n-k):
    result.append(result[i] - nums[i] + nums[i+k])
