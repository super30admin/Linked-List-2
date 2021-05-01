# -*- coding: utf-8 -*-
"""
Created on Fri Apr 30 23:09:01 2021

@author: jgdch
"""

#Time complexity:O(N)
#Space complexity:O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if not head:
            return 
        
        
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next 
            
      
        prev, curr = None, slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next       

        
        first, second = head, prev
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next