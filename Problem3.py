# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None
        count=0
        LengthA=self.getLength(headA)
        LengthB=self.getLength(headB)
        while count<abs(LengthA-LengthB):
            if LengthA>LengthB:
                headA=headA.next
            else:
                headB=headB.next
            count+=1
        while headA and headB:
            if headA==headB:
                return headA
            headA=headA.next
            headB=headB.next
        return None
            
            
    
    
    def getLength(self,head):
        Length=0
        while head:
            head=head.next
            Length+=1
        return Length
        
        