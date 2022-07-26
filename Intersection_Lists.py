# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        first=headA
        second=headB
        
        while first!=second:
            first=headB if first is None else first.next
            second=headA if second is None else second.next
            
        return first
        
        