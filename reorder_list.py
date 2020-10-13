# O(N) TIME AND O(1) SPACE WHERE N IS LENGTH OF LL

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head is None or head.next is None:
            return

        # taking one node extra in first half
        tailOne = self.getTail(head)
        headTwo = self.reverseSecondHalf(tailOne.next)
        tailOne.next = None
        while headTwo is not None:
            p1 = head.next
            p2 = headTwo.next
            head.next = headTwo
            headTwo.next = p1
            head = p1
            headTwo = p2

    def getTail(self,head):
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        return slow

    def reverseSecondHalf(self,node):
        p1 = None
        p2 = node
        while p2 is not None:
            p3 = p2.next
            p2.next = p1
            p1 = p2
            p2 = p3
        return p1
        