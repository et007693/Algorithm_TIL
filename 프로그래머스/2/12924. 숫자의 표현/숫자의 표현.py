def solution(n):
    answer = 0
    start, end = 1, 1
    sum_ = 1
    
    while start <= n:
        if n > sum_:
            end += 1
            sum_ += end
        elif n < sum_:
            sum_ -= start
            start += 1
        else:
            answer += 1
            sum_ -= start
            start += 1
    
    return answer