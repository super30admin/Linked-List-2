# 143. Reorder List

# TC : O(n) where n is the number of nodes in the linked list.
# SC : O(1) as we only use a constant amount of extra space regardless of input size.
# Did this code successfully run on Leetcode : YES

# Approach :
# 1. Find the Middle of the List
    # Use the slow and fast pointer technique to locate the middle of the list
    # The slow pointer moves one step at a time
    # The fast pointer moves two steps at a time
    # When the fast pointer reaches the end, the slow pointer will be at the middle
# 2. Reverse the Second Half
    # Once the middle is found, split the list into two halves
    # Reverse the second half using the standard linked list reversal algorithm:
        # Track previous, current, and next nodes
        # Redirect pointers to reverse direction
        # After reversal, the second half will be in reverse order
# 3. Merge the Two Halves
    # Interleave nodes from the first half and the reversed second half
    # Start with the first node from the first half (maintaining its original position)
    # Alternate between nodes from first half and reversed second half
    # Connect nodes by carefully managing the pointers

from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Edge cases: empty list or single node list
        if not head or not head.next:
            return
        
        # Step 1: Find the middle of the linked list using slow and fast pointers
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # At this point, 'slow' is at the middle of the list
        # Step 2: Reverse the second half of the linked list
        second_half = slow.next
        slow.next = None  # Break the list into two halves
        
        # Reverse the second half
        prev = None
        curr = second_half
        while curr:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp
        
        # Now 'prev' points to the head of the reversed second half
        
        # Step 3: Merge the first half with the reversed second half
        first = head
        second = prev
        
        # Interleave the two halves
        while second:
            temp1 = first.next
            temp2 = second.next
            
            first.next = second
            second.next = temp1
            
            first = temp1
            second = temp2