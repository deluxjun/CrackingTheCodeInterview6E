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