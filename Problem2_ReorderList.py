# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Split list into two halves, reverse the second half, then merge them alternately.
# Use slow and fast pointers to find middle, reverse second half, then interleave nodes from both halves.

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
        if not head or not head.next:
            return
        
        # Step 1: Find the middle of the list
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Split into two lists and reverse the second half
        second = slow.next
        slow.next = None  # Break the connection
        
        # Reverse the second half
        prev = None
        current = second
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        second = prev
        
        # Step 3: Merge the two lists alternately
        first = head
        while second:
            temp1 = first.next
            temp2 = second.next
            first.next = second
            second.next = temp1
            first = temp1
            second = temp2
