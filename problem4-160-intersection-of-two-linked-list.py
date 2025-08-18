# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#time - o(m) + o(n) + o(m) + 0(n)
#space - o(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        countA = 0
        countB = 0

        curr = headA
        while curr != None:
            countA += 1
            curr = curr.next

        curr = headB
        while curr != None:
            countB += 1
            curr = curr.next

        while countA > countB:
            countA = countA - 1
            headA = headA.next

        while countB > countA:
            countB = countB - 1
            headB = headB.next

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA