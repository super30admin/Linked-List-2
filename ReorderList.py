"""
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

"""

# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Need to do 4 steps:
        # 1. find middle
        # 2. reverse 2nd half
        # 3. remove link betewen last element and next element in new node and last element in new node to Null
        # 4. merge two lists
        
        # base 
        if head == None or head.next == None:
            return
        
        # 1. find middle
        slow = head
        fast = head
        
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
            # here, slow will be at mid
            
        # 2. reverse 2nd half
        fast = self.reverse(slow.next)
        
        # 3. remove link betewen last element and next element in new node 
        slow.next = None
        slow = head
        
        # 4. merge 
        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
    
    # function to reverse the 2nd half
    def reverse(self, head):
        prev = None
        self.curr = head
        self.fast = head.next
        
        while(self.fast != None):
            self.curr.next = prev
            prev = self.curr
            self.curr = self.fast
            self.fast = self.fast.next
        
        self.curr.next = prev
        return self.curr
    
    