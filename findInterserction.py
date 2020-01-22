"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.data = x
        self.next = None
    
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        size1 = 0
        size2 = 0
        lst1 = headA
        lst2 = headB
        
        while lst1:
            lst1 = lst1.next
            size1 += 1
            
        while lst2:
            lst2 = lst2.next
            size2 += 1
        
        while size1 > size2 and headA:
            headA = headA.next
            size1 -=1 
                
        while size2 > size1 and headB:
            headB = headB.next
            size2 -= 1
                
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA