"""
Brute Force: save the list nodes in the array and use 2 pointers. one from start of array and another from the end of array
and move both the pointer one step forward while creating the list.
TC: O(n) to store in the array + O(n) to traverse the array
Todo: Implement this
Optimal way:  find the mid-point of linkedlist and reverse the 2nd half of the list. then traverse the first half
and second half simultaneously.
TC: O(n/2) to find mid of list since fast pointer is moving 2 times faster than slow + O(n/2) to reverse the list since
reversing the half list and (n/2) to change the pointers. 
"""
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def find_mid(self, node):
        slow = node
        fast = node
        while fast and fast.next:  # fast for even length and fast.next for odd length
            slow = slow.next
            fast = fast.next.next
        return slow

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return None

        # find the mid-point of the list
        mid = self.find_mid(head)

        # reverse the other half of the list, mid is the first node
        prev = None
        while mid:
            temp = mid.next
            mid.next = prev
            prev = mid
            mid = temp

        # join the list, prev is the one pointing to the head of list
        fast = head
        slow = prev
        while slow:  # the pointer on the reversed list reaches the end first, in case of odd length the number of
            # elements are less in it.
            tempA = fast.next
            tempB = slow.next
            fast.next = slow
            slow.next = tempA
            fast = tempA
            slow = tempB
