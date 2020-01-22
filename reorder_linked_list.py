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
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next: return
        
        slow = head
        fast = head
        
        # find middle
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
        prev = None
        curr = slow.next
        slow.next = None
        
        # reverse list from middle to end
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        # reorder list
        while head and prev:
            temp = head.next
            head.next = prev
            prev = prev.next
            head.next.next = temp
            head = temp