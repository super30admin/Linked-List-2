# Reorder List

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, with Runtime: 88 ms and Memory Usage: 23.4 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using two pinters slow and fast, slow moves one step forward and 
fast moves twice as slow.Finding middle of the list, reversing and 
merging sorted lists

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if not head: 
            return 
        
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next 
            
        prev=None
        curr =slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next       

        first=head 
        second = prev
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next