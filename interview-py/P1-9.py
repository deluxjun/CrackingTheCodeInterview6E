def IsRotatedString(base, rot):
    if (len(base) != len(rot)):
        return False
    all = base + base
    return all.find(rot) >= 0

base = "waterbottle"
rot = "bottlewater"
print(IsRotatedString(base, rot))