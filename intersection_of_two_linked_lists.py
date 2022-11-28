# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        ## T.C = O(n+m)
        ## S.C = O(1)
        
        lenA = 0
        lenB = 0
        hA = headA
        hB = headB
        
        while hA:
            hA = hA.next
            lenA += 1
        
        while hB:
            hB = hB.next
            lenB += 1
            
        hA = headA
        hB = headB
        
        while lenB > lenA:
            hB = hB.next
            lenB -= 1

        while lenA > lenB:
            hA = hA.next
            lenA -= 1
                
        while hA and hB:
            if hA == hB:
                return hA
            hA = hA.next
            hB = hB.next
        
        return None
                