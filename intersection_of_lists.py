# Time complexity: O(n)
# Space complexity: O(1)
# Worked on leetcode: yes
# First, we count the number of elements in each linked list. Then we initialize pointer at the head of the smaller list, and another
# pointer at the difference number of the larger linked list. We keep on incrementing both the pointers one at a time,
# and return the node at which both pointers meet.
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Linkedlist:
    def __init__(self):
        self.head = None

    # this pushes new node at the beginning of the list
    def push(self, new_data):
        new_node = Node(new_data) # first create a node
        new_node.next = self.head
        self.head = new_node


    def printlist(self):
        temp = self.head
        while (temp):
            print(temp.data, end = " ")
            temp = temp.next


def getIntersectionNode(headA, headB):
    countA = 0
    countB = 0

    ptrA = headA
    ptrB = headB

    # find lengths of both lists
    while (ptrA != None):
        ptrA = ptrA.next
        countA += 1

    while (ptrB != None):
        ptrB = ptrB.next
        countB += 1

    print(countA, countB)
    # iterate the longer list by difference of two lists
    ptrA = headA
    ptrB = headB

    if countA >= countB:

        while (countA - countB != 0):
            ptrA = ptrA.next
            countA -= 1

    if countB > countA:

        while (countB - countA != 0):
            ptrB = ptrB.next
            countB -= 1

    print(ptrA)
    while (ptrA != None and ptrB != None and ptrA != ptrB):
        ptrA = ptrA.next
        ptrB = ptrB.next

    return ptrA


llist1 = Linkedlist()
llist1.push(5)
llist1.push(4)
llist1.push(8)
llist1.push(1)
llist1.push(4)
llist1.printlist()

llist2 = Linkedlist()
llist2.push(5)
llist2.push(4)
llist2.push(8)
llist2.push(1)
llist2.push(6)
llist2.push(5)
llist2.printlist()

# generate intersection
llist1.head.next.next = llist2.head.next.next.next

llist1.printlist()
llist2.printlist()

print(getIntersectionNode(llist1.head, llist2.head).data)



