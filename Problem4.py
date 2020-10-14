# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA == None or headB == None:
            return None
        
        ptrA=headA
        ptrB=headB
        
        while ptrA!=ptrB:
            if ptrA==None:
                ptrA=headB
            else:
                ptrA= ptrA.next
            if ptrB==None:
                ptrB=headA
                
            else:
                ptrB = ptrB.next
                
        return ptrA