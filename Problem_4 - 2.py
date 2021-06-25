"""
Time Complexity : O(m + n) where m and n are lengths of respective linked lists. 
Space Complexity : O(1).
    
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curA = headA
        curB = headB
        lenA = lenB = 0 
        
        while curA:
            lenA += 1
            curA = curA.next 
    
        while curB:
            lenB += 1
            curB = curB.next 
        
        while lenA > lenB:
            lenA -= 1 
            headA = headA.next
        
        while lenB > lenA:
            lenB -= 1 
            headB = headB.next
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA 
            
