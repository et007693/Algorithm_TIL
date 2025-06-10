def solution(s):
    result = ''
    capitalize = True

    for ch in s:
        if ch == ' ':
            result += ch
            capitalize = True
        elif capitalize:
            result += ch.upper()
            capitalize = False
        else:
            result += ch.lower()
    
    return result