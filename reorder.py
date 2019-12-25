# Time Complexity : O(n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Logic

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None:
            return
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        p2 = slow.next
        if p2 is None:
            return head
        slow.next = None
        slow = None
        fast = p2.next
        while fast:
            p2.next = slow
            slow = p2
            p2 = fast
            fast = fast.next
        
        p2.next = slow
        
        p1 = head
        
        while p1 and p2:
            temp = p1.next
            p1.next = p2
            p2 = p2.next
            p1.next.next = temp
            p1 = temp
            
            
        