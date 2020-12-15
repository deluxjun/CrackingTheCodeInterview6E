def rotate(m):
    compressed = []
    counter = 0

    n = len(m)
    size = n - 1
    for i in range(n // 2):
        for j in range(i, size):
            top = m[i][j]
            m[i][j] = m[size-j][i]
            m[size-j][i] = m[size-i][size-j]
            m[size-i][size-j] = m[j][size-i]
            m[j][size-i] = top

    return m

# save 0,0
# 0,0 = 3,0
# 3,0 = 3,3
# 3,3 = 0,3
# 0,3 = saved

# save 1,1
# 1,1 = 2,1
# 2,1 = 2,2
# 2,2 = 1,2
# 1,2 = saved


m = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12],
    [13, 14, 15, 16],
]

# m = [
#     [13, 9, 5, 1],
#     [14, 10, 6, 2],
#     [15, 11, 7, 3],
#     [16, 12, 8, 4],
# ]

print(rotate(m))

