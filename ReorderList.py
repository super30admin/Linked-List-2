# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# 3 step process, first determine the mid by slow and fast pointer
# Then reverse the second half of the linked list
# then merge, basically update the pointers.

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

        slow = head
        fast = head
        while (fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next

        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        while (fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, node):
        prev = None
        curr = node
        while (curr != None):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
