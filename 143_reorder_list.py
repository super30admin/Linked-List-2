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
        """
            https://leetcode.com/problems/reorder-list/
            // Time Complexity : O(n)
            // Space Complexity : O(1)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                - Find mid in the list
                - Reverse the list from mid
                - Merge two linked list
        """
        if not head or not head.next:
            return

        # find mid
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # reverse the list from mid
        prev = fast = None
        # slow is now at mid
        cur = slow.next
        # detach the list
        slow.next = None

        while cur:
            fast = cur.next
            cur.next = prev
            prev = cur
            cur = fast

        # mergint two linked list
        dummy = head
        # fast is now pointing to second half
        fast = prev
        # slow is pointing to first half
        slow = head
        tmp = None
        while fast and slow:
            tmp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = tmp
            slow = tmp
