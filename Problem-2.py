# Approach
# maintain two pointers fast and slow. fast move twice ffast than slow. find the mid point of the linked list.
# reverse the second part from mid
# start from first part for every node add the one fro from reversed list untill second list is Nobe

# Complexities
#Time Complexity: O(n)
# Space Complexity: O(1)


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
from typing import Optional


class Solution:
    def reverse(self, head):
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = head
        fast = head

        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp



