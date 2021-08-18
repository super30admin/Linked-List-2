"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
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
        if not head:
            return 
        slow = fast = head
        # Find the middle element
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        previous, current = None, slow
        # Reverse partitioned list
        while current:
            current.next, previous, current = previous, current, current.next
        first = head
        second = previous
        # Merge two lists into one
        while second.next:
            first.next, first = second, first.next
            second.next, second = first , second.next