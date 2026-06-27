## Problem2 (https://leetcode.com/problems/reorder-list/)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity: O(N) 
# The algorithm traverses the list of N nodes sequentially three times: 
# once to find the middle (O(N/2)), once to reverse the second half (O(N/2)), 
# and once to merge the two halves (O(N/2)). This simplifies to O(N).

# Space Complexity: O(1)
# The reordering is done entirely in-place. We only use a few auxiliary 
# pointers (slow, fast, prev, current, temp) to restructure the list, 
# requiring no additional memory proportional to the input size.

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return

        # Phase 1: Locate the midpoint of the linked list
        # We use the fast and slow pointer technique. Slow moves 1 step, fast moves 2 steps.
        # When fast reaches the end, slow will point to the middle element.
        slow = head
        fast = head
        while fast is not None and fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next


        # Phase 2: Split the list into two halves and reverse the second half
        # 'fast' now points to the start of the second half, and we sever the tie 
        # from the first half by setting slow.next to None.
        fast = slow.next 
        slow.next = None 
        slow = head      
        
        prev = None
        current = fast

        # Standard iterative linked list reversal for the right half
        while current is not None:
            temp = current.next
            current.next = prev
            prev = current
            current = temp

        # 'prev' is now the new head of the reversed second half
        fast = prev 


        # Phase 3: Merge the two halves node by node
        # We alternate pointers, inserting nodes from the second half (fast) 
        # in between the nodes of the first half (slow).
        while fast is not None:
            temp = slow.next
            
            # Link current node of first half to current node of second half
            slow.next = fast
            
            # Move the fast pointer to the next node in the second half
            fast = fast.next
            
            # Link the newly inserted node back to the rest of the first half
            slow.next.next = temp
            
            # Advance the slow pointer to the next insertion point
            slow = temp