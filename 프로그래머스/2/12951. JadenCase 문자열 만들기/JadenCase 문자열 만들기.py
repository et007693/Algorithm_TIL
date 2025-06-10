def solution(s):
    result = ''
    first = True

    for ch in s:
        if ch == ' ':
            result += ch
            first = True
        elif first:
            result += ch.upper()
            first = False
        else:
            result += ch.lower()
    
    return result