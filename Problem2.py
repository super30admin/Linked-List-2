# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time complexity:O(n), n being the nodes in the list.
# To find middle we take O(n) time. To reverse O(n/2) and for merge as well  O(n/2). Highest order is O(n)
# Space complexity:O(1) for the pointers
# Approach:First find the middle of the list. Reverse the second list and then merge the two
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        while fast and fast.next:  # find middle
            fast = fast.next.next
            slow = slow.next
        prev = None
        curr = slow
        while curr:  # reverse second list
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        first = head
        second = prev
        while second and second.next:  # merge
            temp = first.next
            first.next = second
            first = temp

            temp = second.next
            second.next = first
            second = temp



