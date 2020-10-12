# Time Complexity: O(N)
# Space Complexity: O(1)
# Passed Leetcode

import math
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        
        if not head.next or not head.next.next:
            return head
        
        p2 = p1 = head
        
        while p2 and p2.next:
            
            p1 = p1.next
            p2 = p2.next.next
        
        
        new_head = p1.next
        p1.next = None
        
        p1 = new_head
       
        p2 = p1.next
        
        p1.next = None
        
        while p2:
            
            temp = p2.next
            
            p2.next = p1
            
            p1 = p2
            p2 = temp
        
        
        while p1:
            
            temp1 = head.next
            temp2 = p1.next
            head.next = p1
            p1.next = temp1
            
            p1 = temp2
            head = temp1
        
        
            
        
        
        
        