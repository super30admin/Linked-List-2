# Time Complexity: O(N)
# Space Complexity: O(1)
# Passed Leetcode

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    
    def get_length(self, head):
        m = 0
        while head:
            head = head.next
            
            m += 1
        
        return m
    
    def get_start_node(self, head, diff):
        i = 0
        while i < diff:
            head = head.next
            
            i += 1
        
        return head
    
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        
        if not headA or not headB:
            return None
        
        m = self.get_length(headA)
        n = self.get_length(headB)
            
        diff = abs(m - n)
        if m < n:
            hB = self.get_start_node(headB, diff)
            hA = headA
        else:
            hA = self.get_start_node(headA, diff)
            hB = headB
        
        while hA and hB:
            
            if hA == hB:
                return hA
            hA = hA.next
            hB = hB.next
        
        return None
        
            
        
        
            
        