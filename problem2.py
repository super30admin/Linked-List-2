# https://leetcode.com/problems/reorder-list/

# Time Complexity : O(N) where N is number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, one bug fixed it later.


# Your code here along with comments explaining your approach

# Approach : We first find the middle of the linked by adding a dummy node our job will be easy. We then reverse
# second half of the linkedlist. Now we have two lists ready, then we merge them and return the head.

from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        dummy = ListNode(-1, head)
        slow, fast = dummy, dummy

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverse(slow.next)
        slow.next = None

        head1, head2, next_ = head, fast, head.next

        while head2 is not None and next_ is not None:
            head1.next = head2
            head2 = head2.next
            head1.next.next = next_
            head1 = next_
            next_ = next_.next
        head1.next = head2

        return head

    def reverse(self, cur):
        prev = None
        while cur is not None:
            next_ = cur.next
            cur.next = prev
            prev = cur
            cur = next_
        return prev


# temp = [2, 3, 4, 5]
# head = ListNode(1, None)
# cur = head
# for i in temp:
#     cur.next = ListNode(i, None)
#     cur = cur.next
# sol = Solution()
# sol.reorderList(head)
# while head is not None:
#     print(head.val, end=" ")
#     head = head.next
