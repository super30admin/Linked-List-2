"""
Problem: Reorder List
Approach: reverse the second half od the list and then swap relink the tails and heads
t.c. => O(n)
s.c. => O(1)
"""
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
        tail = None
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev = None
        
        tempHead = slow.next
        slow.next = None
        while tempHead:
            nxt = tempHead.next
            tempHead.next = prev
            prev = tempHead
            tempHead = nxt
        tail = prev
        while tail:
            headNxt = head.next
            tailNxt = tail.next
            head.next = tail
            tail.next = headNxt
            tail = tailNxt
            head = headNxt
        return 
