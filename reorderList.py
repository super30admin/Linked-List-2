# This solution reorders a linked list in-place by rearranging nodes in the pattern: first node → last node → second node → second last node → ...
# It first finds the middle of the list using the slow and fast pointer technique.
# Then it reverses the second half and merges both halves together by alternating nodes.

# Time Complexity: O(n), where n is the number of nodes in the list. Each step (finding the middle, reversing, and merging) is linear.
# Space Complexity: O(1), since all operations are done in-place without additional memory.

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
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Reverse the second half
        prev, cur = None, slow.next
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        slow.next = None  # Split the list

        # Step 3: Merge two halves
        head1 = head
        head2 = prev
        while head1 and head2:
            nxt1 = head1.next
            nxt2 = head2.next

            head1.next = head2
            head1 = nxt1

            head2.next = head1
            head2 = nxt2
