# Time complexity - O(n)
# Space complexity - O(1)

# Approach - Find the mid of the LL, break the LL at mid, reverse the second half of the LL. The merge the
# first half of LL with reversed second half of LL.

from typing import Optional
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
        if head == None:
            return
        
        slow = head
        fast = head

        # find mid
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        mid = slow

        # reverse second half of LL
        fast = self.reverse(slow.next)
        slow.next = None
        
        # merge two LL
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
    
    def reverse(self, head: Optional[ListNode]) -> ListNode:
        if head == None or head.next == None:
            return head
        prev = None
        curr = head
        fast = curr.next

        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr