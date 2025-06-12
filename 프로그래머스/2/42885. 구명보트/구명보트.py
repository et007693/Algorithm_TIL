from collections import deque

def solution(people, limit):
    answer = 0
    people.sort()
    people = deque(people)
    
    while people:
        if len(people) > 1 and limit - people[-1] >= people[0]:
            people.popleft()
            people.pop()
        else:
            people.pop()
        answer += 1
        
    return answer