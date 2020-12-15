def compress(s):
    compressed = []
    counter = 0

    for i in range(len(s)):
        if i != 0 and s[i] != s[i-1]:
            compressed.append(s[i-1] + str(counter))
            counter = 0
        counter += 1

    compressed.append(s[-1] + str(counter))
    return min(s, ''.join(compressed), key=len)

print(compress("aabccccaa"))
print("aabccccabc"[-1])
