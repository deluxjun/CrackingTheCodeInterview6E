import random

class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def __str__(self):
        return str(self.value)

class LinkedList:
    def __init__(self, values = None):
        self.head = None
        self.tail = None
        if values is not None:
            for x in values:
                self.add(x)

    def __iter__(self):
        current = self.head
        while current:
            yield current
            current = current.next

    def __str__(self):
        return ' -> '.join([str(x) for x in self])

    def __len__(self):
        result = 0
        node = self.head
        while node:
            node = node.next
            result += 1
        return result

    def add(self, value):
        if self.head == None:
            self.tail = self.head = Node(value)
        else:
            self.tail.next = Node(value)
            self.tail = self.tail.next
        return self.tail

    def generate(self, n, min_value, max_value):
        self.head = self.tail = None
        for i in range(n):
            self.add(random.randint(min_value, max_value))
        return self

    def delete(self, value):
        temp = self.head
        prev = None
        while temp is not None:
            if temp.value == value:
                break;
            prev = temp
            temp = temp.next

        if prev is not None:
            prev.next = temp.next
            temp = None

    def addMulti(self, values):
        for x in values:
            self.add(x)