# Time Complexity:- O(n)
# Space Complexity:- O(n)
# Approach:- Hold the elements in a queue first popleft and then popright link the elements. Kepp continuing with the same until we have elements in the queue
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import collections

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        d=collections.deque([])
        while(head is not None):
            d.append(head)
            head=head.next
        self.head=d.popleft()
        head=self.head
        while(d):
            head.next=d.pop()
            head=head.next
            if d:
                head.next=d.popleft()
                head=head.next
        head.next=None
        return self.head
        