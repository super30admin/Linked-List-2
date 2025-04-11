# Time Complexity : O(2n), where n is the number of nodes in the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# First, we find the middle of the linked list using the fast and slow pointer technique.
# Then, we reverse the second half of the linked list.
# Finally, we merge the two halves of the linked list in, processing 1 node from the first half and 1 node from the second half alternately.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Find the middle of the linked list using fast and slow pointers
        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the linked list
        # Now, slow points to the middle of the linked list

        prev = None
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
        # Now, prev points to the head of the reversed second half

        # Merge the two halves of the linked list
        # head points to the first half and prev points to the second half
        while prev.next:
            # Two temporary pointers to hold the next nodes of the first and second halves
            tmp1 = prev.next
            tmp2 = head.next
            # Reorder the nodes
            # Link the first half node to the second half node
            head.next = prev
            # Link the second half node to the next node of the first half
            prev.next = tmp2
            # Move the pointers forward
            prev = tmp1
            head = tmp2
