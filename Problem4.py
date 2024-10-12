# 160. Intersection of Two Linked Lists
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p1 = headA
        p2 = headB
        countA = 0 
        countB = 0

        while p1 is not None:
            countA += 1
            p1 = p1.next

        while p2 is not None:
            countB += 1
            p2 = p2.next

        p1 = headA
        p2 = headB

        while countA > countB:
            p1 = p1.next
            countA -= 1

        while countB > countA:
            p2 = p2.next
            countB -= 1

        while p1 != p2:
            p1 = p1.next
            p2 = p2.next

        return p1

        


        