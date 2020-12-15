def calEditCount(s, t):
    table = {}
    for c in s:
        table[c] = 1

    for c in t:
        table[c] = 0

    total = 0
    for c in table.values():
        if c == 1:
            total += 1
            if total > 1:
                return False

    return True

print(calEditCount("pale", "bale"))
