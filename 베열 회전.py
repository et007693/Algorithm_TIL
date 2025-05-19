arr = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]

# 열 선택
print(list(zip(*arr)))

# 시계방향 회전
rotate_arr = [list(row) for row in zip(*arr[::-1])]
for a in rotate_arr:
    print(a)

# 반시계 방향 회전
rotate_arr = [list(row) for row in zip(*arr)][::-1]
for a in rotate_arr:
    print(a)
