from collections import deque

def solution(food):
    q = deque([0])
    for f in range(len(food)-1, 0, -1):
        for _ in range(food[f]//2):
            q.appendleft(f)
            q.append(f)
    answer = ''
    for i in q:
        answer += str(i)
    return answer