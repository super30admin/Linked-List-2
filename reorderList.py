# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
1. reverse the second half of the linked list
2. merge the first and reverse linked list
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head: return
        
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        prev, curr = None, slow
        while curr:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        
        first, second = head, prev
        while second.next:
            tmp = first.next
            first.next = second
            first = tmp

            tmp = second.next
            second.next = first
            second = tmp