## 8.2
If we start from 0,0 position, then this problem is more difficult.
because what if the last position(r-1 or c-1) is off limits?
So, let's think of processing from r,c and we are using boolean array. map[r][c], r : row, c : column
Also, we are using HashSet for caching. that's because we have to skip a past failed path.

## 8.3
Magic Index

We can think just a simple solution. But, we can use sorted array.
This can be solved like a binary search tree.
-12 -5 1 2 4 10 20
  0  1 2 3 4  5  6

1. search mid index value. (3,value=4)
2. if index is equal to value, that is magic index.
3. the value is smaller than index? then, magic index is right side, or left side.

## 8.4
Subset

Just think about {1,2} set.
All subset we can make is {} {1} {2} {12}, we call that as P(2)
Now, let's make subset list of {1,2,3}
1. Adding '3' element on all each subset of P(2), the result is {3} {13} {23} {123}
2. Add number 1's list to P(2), that is {} {1} {2} {12} {3} {13} {23} {123}
3. As a result, P(n) = P(n-1) + {add n in each P(n-1)}

1
P(1) = {} {1}

1 2
P(2) = {} {1} {2} {12}

1 2 3
P(3) = {} {1} {2} {12} {3} {13} {23} {123}

P(n) = P(n-1) + {add n in each P(n-1)}

```
ArrayList list p(int[] n) {
  if (n.length < 1)
    return emptyList;

  make subset sub = (n-1)
  preList = p(sub);
  clonedList.addAll(preList);
  foreach(sub in preList) {
    clonedList.add(sub.add(n))
  }
  list.addAll(preList);
  list.addAll(clonedList);
  return list;
}
```

## 8.5
Recursive Multiply
Let's think about doubling..
If not even,
- 8 * 7 = 2 * (8 * 3) + 8
- 8 * 3 = 2 * (8 * 1) + 8
- 8 * 1 = 8
If even,
- 8 * 4 = 2 * (8 * 2)
- 8 * 2 = 2 * (8 * 1)

```
multi(small, big) {
  if (small == 1)
    return big;
  div = small >> 1;
  value = multi(div, big)
  if (small % 2 == 1)
    return value << 1 + big;
  return value << 1
}
```

## 8.6

s : Source
b : Buffer
t : Target

move(1, s, b, t) : t.push(s.pop())
move(2, s, b, t) : move(1, s, t, b) | t.push(2) | move(1, b, s, t)
move(3, s, b, t) : move(2, s, t, b) | t.push(3) | move(2, b, s, t)

```
move(int n, s, b, t) {
  if (n == 1) {
    t.push(s.pop())
  }
  move(n-1, s, t, b)
  t.push(n)
  move(n-1, b, s, t)
}
```
