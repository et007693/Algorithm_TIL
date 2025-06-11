def solution(n):
    answer = n+1
    cnt = bin(n).count('1')
    
    while bin(answer).count('1') != cnt:
        answer += 1
    
    return answer