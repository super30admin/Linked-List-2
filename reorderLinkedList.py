"""Approach: 3 steps, find mid, reverse second half of the list and merge them
TC O(n)
SC O(1)"""
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
        if not head.next or not head.next.next:
            return 
        # find middle of linkedList
        p1, p2 = head, head
        while p2:  # O(n)
            p2 = p2.next
            if p2:
                p2 = p2.next
                p1 = p1.next
        
        # reverse from middle onward
        
        p2 = p1.next
        p3 = p2.next
        p1.next = None
        p1 = None
        
        while p3:  # O(n/2)
            p2.next = p1
            p1 = p2
            p2 = p3
            p3 = p3.next
        p2.next = p1
        head2 = p2
        
        
        # merge linkedLists
        p1, p2 = head, head2
        while p1 and p2:  # O(n/2)
            tmp = p1.next 
            p1.next = p2
            p2 = p2.next
            p1.next.next = tmp
            p1 = tmp
        