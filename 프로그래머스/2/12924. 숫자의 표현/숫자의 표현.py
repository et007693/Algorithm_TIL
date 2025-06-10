def solution(n):
    answer = 0
    
    def dfs(idx, total):
        nonlocal answer
        if total == n:
            answer += 1
            return
        if total > n:
            return
        
        dfs(idx+1, total+idx+1)
        
    for i in range(1, n+1):
        dfs(i, i)
        
    return answer