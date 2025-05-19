# import sys
# input = sys.stdin.readline

n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

def rotate_matrix(matrix, N, M, R):
    result = [row[:] for row in matrix]
    layers = min(N, M) // 2

    for layer in range(layers):
        elements = []

        for i in range(layer, M - layer):
            elements.append(matrix[layer][i])
        for i in range(layer + 1, N - 1 - layer):
            elements.append(matrix[i][M - 1 - layer])
        for i in range(M - 1 - layer, layer - 1, -1):
            elements.append(matrix[N - 1 - layer][i])
        for i in range(N - 2 - layer, layer, -1):
            elements.append(matrix[i][layer])

        r = R % len(elements)
        rotated = elements[r:] + elements[:r]

        idx = 0
        for i in range(layer, M - layer):
            result[layer][i] = rotated[idx]
            idx += 1
        for i in range(layer + 1, N - 1 - layer):
            result[i][M - 1 - layer] = rotated[idx]
            idx += 1
        for i in range(M - 1 - layer, layer - 1, -1):
            result[N - 1 - layer][i] = rotated[idx]
            idx += 1
        for i in range(N - 2 - layer, layer, -1):
            result[i][layer] = rotated[idx]
            idx += 1

    return result

result = rotate_matrix(arr, n, m, r)
for a in result:
    print(*a)
