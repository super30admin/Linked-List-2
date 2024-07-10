# Time Complexity :
# O(m+n)
# space complexity : O(1)

# Approach :

#  calculate the length of both the lists
#  whichever is greater, traverse that list for the difference in the length of both lists
#  once the same address node is found, we can return the intersection

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        if not headA or not headB:
            return None

        pointer = headA
        countA = 0
        countB = 0

        while pointer is not None:
            pointer = pointer.next
            countA = countA+1

        pointer = headB

        while pointer is not None:
            pointer = pointer.next
            countB = countB+1

        while countA > countB:
            headA = headA.next
            countA = countA-1

        while countB > countA:
            headB = headB.next
            countB = countB-1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
