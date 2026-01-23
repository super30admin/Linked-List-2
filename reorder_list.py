"""
time = o(n)
space = o(1)
we use slow and fast pointers to find the middle of the linked list, we then reverse the linked list from the middle point
and then zip the two together. We need to be careful when there are even number of nodes, in that case the last node has to be reattached
to the same linked list for continuinty. 
"""
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverse(self, head):
        prev = None
        curr = head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head.next:
            return head
        slow = fast = head
        prev = None
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        prev.next = None
        p1 = head
        p2 = self.reverse(slow)
        while p1 and p2:
            next1 = p1.next
            next2 = p2.next
            p1.next = p2
            p2.next = next1 if next1 else next2
            p1 = next1
            p2 = next2
        return head
        