from collections import deque

def solution(food):
    answer = '0'
    for f in range(len(food)-1, 0, -1):
        for _ in range(food[f]//2):
            answer = f'{f}{answer}{f}'
    return answer