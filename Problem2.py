"""
TC: O(N) {we iterate throught the list multiple times, one to find mid, another to reverse the half and the last to adjust the ptrs.}
SC: O(1) {We dont use any extra space}

Approach:

We first find the middle of the list using fast and slow pointer (tortoise and hare algorithm). We then reverse the later half
of the list to conviniently work on the problem flow ie L0 -> Ln -> L1 -> Ln-1 etc.

We then take alternate ptr approach to point the alternate between the first half and second reversed half.
s

The problem ran successfully on LeetCode.
"""

from typing import List, Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        prev = None
        curr = slow.next
        slow.next = None

        while curr:
            temp = curr.next
            curr.next = prev 
            prev = curr
            curr = temp

        one, two = head, prev

        while one and two:

            temp1 = one.next
            temp2 = two.next
            
            one.next = two
            two.next = temp1

            one = temp1
            two = temp2
        