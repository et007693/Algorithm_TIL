# dict.get
# 중첩 가능, 첫번째 값이 없다면 두번째 값을 return
end = 14
arr1 = {3: 22, 5: 8, 11: 26, 20: 29}
arr2 = {27: 1, 21: 9, 17: 4, 19: 7}
next_pos = arr1.get(end, arr2.get(end, end))
