# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # TC : O(m+n)
        # SC : O(1)
        if headA is None and headB is None:
            return None
        if headA is None or headB is None:
            return None
        ptrA,ptrB = headA,headB
        lenA,lenB = 0,0
        while ptrA != None:
            lenA += 1
            ptrA = ptrA.next
        while ptrB != None:
            lenB += 1
            ptrB = ptrB.next
        
        ptrA,ptrB = headA,headB
        
        while lenA > lenB:
            ptrA = ptrA.next
            lenA -= 1
        
        while lenB > lenA:
            ptrB = ptrB.next
            lenB -= 1
        
        while ptrA and ptrB:
            if ptrA == ptrB:
                return ptrA
            ptrA = ptrA.next
            ptrB = ptrB.next
        return None

