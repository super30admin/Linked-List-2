# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Space Complexity - o(1)
# Time Complexity - o(n)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        l1 = 0
        l2 = 0

        ptA = headA
        ptB = headB

        while ptA:
            l1+=1
            ptA = ptA.next

        while ptB:
            l2+=1
            ptB = ptB.next

        ptA = headA
        ptB = headB

        if l1>l2:
            while l1>l2:
                ptA = ptA.next
                l1-=1

        if l2>l1:
            while l2>l1:
                ptB = ptB.next
                l2-=1

        while ptA!=ptB:
            ptA = ptA.next
            ptB = ptB.next

        return ptA