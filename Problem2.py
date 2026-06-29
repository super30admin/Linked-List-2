# Problem2 (https://leetcode.com/problems/reorder-list/)
#Time Complexity: O(n), three sequential passes through the list (find middle, reverse second half, merge) each touching roughly n/2 nodes. They run one after another, not nested, so the work adds up to O(n) instead of multiplying into O(n^2).
#Space Complexity: O(1), only a fixed handful of pointer variables are used 
#Approach: Find the middle of the list using slow/fast pointers, reverse the second half, then merge the two halves together by alternating one node from the first half with one from the reversed second half (zig-zag merge).


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
        # Slow/fast pointers to find the middle, fast moves 2 steps for every 1 step slow takes, so when fast hits the end, slow is at the last node of the first half
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse everything after slow (the second half), then cut the
        # first half off cleanly so it doesn't still point into the second
        reversehead = self.reverse(slow.next)
        slow.next = None

        # Reset pointers to walk both halves for merging: fast walks the
        # reversed second half, slow walks the first half
        fast = reversehead
        slow = head

        # Zig-zag merge: splice one node from the reversed half in right after each node of the first half. 
        #We save the first half's next node in temperory before overwriting the pointer, so we don't lose our place and can continue the merge from there
        while fast:
            temperory = slow.next       # save where the first half continues
            slow.next = fast            # attach current reversed-half node here
            fast = fast.next            # advance fast through the reversed half
            slow.next.next = temperory  # reconnect back to the saved first-half node
            slow = temperory            # move slow forward to continue merging

    def reverse(self, head: Optional[ListNode]) -> None:
        # Standard in-place reversal: walk forward through the list, flipping each node's .next to point backward instead of forward
        previous = None
        current = head

        while current:
            temperory = current.next   # save the next node before overwriting current.next
            current.next = previous    # flip the pointer to point backward
            previous = current         # move previous forward to current
            current = temperory        # move current forward to the saved next node
        return previous