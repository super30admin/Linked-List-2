# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
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
        fast = head.next
        while (fast and fast.next):
            slow = slow.next
            fast = fast.next.next

        # reverse second half of the list

        prev = None
        cur = slow.next
        slow.next = None

        while (cur):
            tmp = cur.next
            cur.next = prev
            prev = cur
            cur = tmp

        p1 = head
        cur = prev

        while (cur):
            tmp = p1.next
            tmp2 = cur.next
            p1.next = cur

            cur.next = tmp
            p1 = tmp
            cur = tmp2
