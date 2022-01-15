# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # base condition
        if not head:
            return

        # find the middle of linked list
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse the second part of the list
        prev = None
        curr = slow

        while curr:
            curr.next, prev, curr = prev, curr, curr.next

        # merge two sorted linked lists

        first = head
        second = prev

        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
