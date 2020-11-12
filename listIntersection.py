# The easy way to solve this problem would be first calculating the length of both lists, then bringing both pointers to same length and traversing the list until the both pointers point to same node
#Time Complexity: O(n)
#Space Complexity: O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def findIntersection(self,h1,h2):
        l1 = 0
        l2 = 0
        t1 = h1
        t2 = h2
        while t1 is not None:
            l1 = l1 + 1
            t1 = t1.next
        while t2 is not None:
            l2 = l2 + 1
            t2 = t2.next
        t1 = h1
        t2 = h2
        if l1 > l2:
            t1 = t1.next
            l1 = l1 - 1
        elif l2 > l1:
            t2 = t2.next
            l2 = l2 - 1
        while t1 != t2:
            t1 = t1.next
            t2 = t2.next
        if t1 == t2:
            return t1
        else:
            return None





n1 = ListNode(4)
n2 = ListNode(1)
n3 = ListNode(8)
n4 = ListNode(5)
n5 = ListNode(6)
n6 = ListNode(1)
n7 = ListNode(4)
n8 = ListNode(5)
n1.next = n2
n2.next = n3
n3.next = n7
n7.next = n8
n4.next = n5
n5.next = n6
n6.next = n3
s = ListNode()
node = s.findIntersection(n1,n4)
print(node.val)