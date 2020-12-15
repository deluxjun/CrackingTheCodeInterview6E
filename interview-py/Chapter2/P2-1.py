from LinkedList import LinkedList

def removeDups(ll):
    current = ll.head
    while current is not None:
        runner = current
        while runner.next is not None:
            if current.value == runner.next.value:
                runner.next = runner.next.next
            else:
                runner = runner.next
        current = current.next
    return ll

def kth_to_last(ll, k):
    runner = current = ll.head
    for i in range(k):
        if runner is None:
            return None
        runner = runner.next

    while runner:
        current = current.next
        runner = runner.next

    return current

ll = LinkedList()
ll.generate(10, 0, 7)
print(ll)
# print(removeDups(ll))

print(kth_to_last(ll,4))
