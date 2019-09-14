# Time Complexity : O(n) 
# Space Complexity : O(1) (We are using only some temperory variables)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Find mid point of link list using slow and fast. Make first and second linklist by cutting from that midpoint.
# - Reverse the second link list.
# - Combine first and second link list

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
#       Initialize slow and fast pointer
        slow = head
        fast = head
#       Check corner case
        if not head:
            return
        
#       Run slow and fast algorithm, where slow takes one step and fast takes 2 steps at a time.
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
#       Break from the mid point but store head of second liklist before breaking it.
        mid = slow.next
        slow.next = None
        
#       Reverse the second link list
        prev = None
        nex = None
        while mid:
            nex = mid.next
            mid.next = prev
            prev = mid
            mid = nex
            
        second = prev
        first = head
        
#       Combine first and second link list.
        while first and second:
            firstnext = first.next
            secondnext = second.next
            first.next = second
            second.next = firstnext
            first = firstnext
            second = secondnext
