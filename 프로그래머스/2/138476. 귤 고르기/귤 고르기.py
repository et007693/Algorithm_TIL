from collections import Counter

def solution(k, tangerine):
    answer = 0
    cnt = 0
    
    tangerine_dict = Counter(tangerine)
    tangerine = sorted(tangerine_dict.items(), key=lambda x: x[1], reverse=True)
    
    while cnt < k:
        cnt += tangerine[answer][1]
        answer += 1
    
    return answer