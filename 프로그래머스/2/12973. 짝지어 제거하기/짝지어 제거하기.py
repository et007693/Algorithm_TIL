def solution(s):
    stack = []
    
    for c in s:
        if stack and c == stack[-1]:
            stack.pop()
        else:
            stack.append(c)
            
    answer = 0 if stack else 1
        
    return answer