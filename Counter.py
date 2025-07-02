# 데이터의 갯수를 셀 때는 Counter 사용하기
from collections import Counter
arr = [1,1,1,2,2,3,4,4,4,5,6,7,7,8,8,8,8,9,9,9,9,9]
print(Counter(arr))

arr = Counter(arr)
arr.items() # key, value 반환
arr.values() # 값들만 반환
arr.keys() # 키들만 반환

