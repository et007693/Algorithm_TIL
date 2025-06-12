def solution(k, tangerine):
    answer = 0
    sum_ = 0
    l = [0] * max(tangerine)
    
    for t in tangerine:
        l[t-1] += 1
    l.sort(reverse = True)
    
    while sum_ < k:
        sum_ += l[answer]
        answer += 1
    
    return answer