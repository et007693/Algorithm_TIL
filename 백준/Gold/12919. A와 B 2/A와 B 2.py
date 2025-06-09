s = input()
t = input()

def dfs(t):
    if len(t) == len(s):
        if t == s:
            print(1)
            exit()
        else:
            return
    if t[-1] == "A":
        dfs(t[:-1])
    if t[0] == "B":
        dfs(t[::-1][:-1])

dfs(t)
print(0)