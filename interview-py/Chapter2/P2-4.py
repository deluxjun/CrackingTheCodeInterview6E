from Chapter2.LinkedList import LinkedList


def classify(ll, base):
    current = ll.tail = ll.head
    while current:
        nextNode = current.next
        current.next = None
        if current.value >= base:
            ll.tail.next = current
            ll.tail = current
        else:
            current.next = ll.head
            ll.head = current
        current = nextNode
    if ll.tail.next is not None:
        ll.tail.next = None

    return ll

def partition(ll, base):
    set_a = []
    set_b = []

    current = ll.head
    while current:
        if current.value >= base:
            set_b.append(current)
        else:
            set_a.append(current)
        current = current.next

    set_c = set_a + set_b
    return LinkedList(x for x in set_c)

ll = LinkedList()
ll.addMulti([6,7,8])
ll.add(5)
ll.addMulti([9,1,2])
print(ll)
print(partition(ll, 5))


