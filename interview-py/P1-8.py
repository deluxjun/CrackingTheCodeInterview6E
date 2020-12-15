def makeCol(m, row, colLen):
    for j in range(colLen):
        m[row][j] = 0

def makeRow(m, col, rowLen):
    for j in range(rowLen):
        m[j][col] = 0

def makeZero(m):
    rowLen = len(m)
    colLen = len(m[0])
    rows = []
    cols = []
    for i in range(rowLen):
        for j in range(colLen):
            if m[i][j] == 0:
                rows.append(i)
                cols.append(j)

    for row in rows:
        makeCol(m, row, colLen)

    for col in cols:
        makeRow(m, col, rowLen)

    return m

m = [
    [1,  2,   3,  4],
    [5,  6,   7,  8],
    [9,  10,  0, 12],
    [13, 14, 15, 16],
]

print(makeZero(m))