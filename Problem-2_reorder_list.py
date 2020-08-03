# APPROACH  
# Time Complexity : O(n), n: length of the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Find the middle of the linked list using slow, fast pointers
# 2. Reverse only the second half of the list and return the head of this reversed list
# 3. Rearrange according to the order of the question


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if head is None or head.next is None:
            return head
        
        slow, fast = head, head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
            
        prev, curr, curr_next = None, slow.next, slow.next.next
        while curr_next is not None:
            curr.next = prev
            prev = curr
            curr = curr_next
            curr_next = curr_next.next
            
        curr.next = prev
        slow.next = None
        slow, fast, temp = head, curr, None
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            
        return head
        
