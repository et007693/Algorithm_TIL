def solution(n, words):
    stack = []
    
    for i, word in enumerate(words):
        if word in stack or (stack and stack[-1][-1] != word[0]):
            
            return [(i % n) + 1, (i // n) + 1]
        else:
            stack.append(word)
    return [0, 0]