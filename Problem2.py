# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head):
        """
        Do not return anything, modify head in-place instead.
        """

        # find mid point
        fast = head
        slow = head
        while (fast is not None and fast.next is not None):
            fast = fast.next.next
            slow = slow.next

        # reverse second list
        p2 = self.reverse(slow.next)
        slow.next = None

        # reorder list
        p1 = head

        while (p2 is not None and p1 is not None):
            p1n = p1.next
            p1.next = p2
            p2n = p2.next
            p2.next = p1n

            p1 = p1n
            p2 = p2n

    def reverse(self, node):
        curr = node
        prev = None
        next = None

        while (curr is not None):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        return prev

# TC:O(n)
# SC:O(1)


