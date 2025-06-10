def solution(bandage, health, attacks):
    m_health = health
    start = 0
    
    for a_time, damage in attacks:
        sc = a_time - start - 1
        start = a_time
        health = min(m_health, (sc*bandage[1] + ((sc//bandage[0]) * bandage[2]))+health)
        health -= damage
        
        if health <= 0:
            break
        
    if health > 0:
        return health
    else:
        return -1
