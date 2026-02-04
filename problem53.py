# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        #now slow will point to the middle node
        prev = None
        curr = slow.next

        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        slow.next = None

        l1 = head
        l2 = prev


        while l2:#l2 will be slower or same size
            temp1 = l1.next

            l1.next = l2
            l2 = l2.next  
            l1.next.next = temp1

            l1 = temp1

# Time Complexity: O(N)
# Space Complexity: O(1)