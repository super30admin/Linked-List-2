"""
Brute Force
Time Complexity : O(m + n) where m and n are lengths of respective linked lists. 
Space Complexity : O(n).
    
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        set_A = set()
        curA = headA
        
        while curA:
            set_A.add(curA)
            curA = curA.next 
        
        curB = headB
        
        while curB:
            if curB in set_A:
                return curB
            else:
                curB = curB.next 
        
        return None 