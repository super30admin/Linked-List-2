# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self,head):
        prev,curr,fast = None,head,head.next
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return  
        slow,fast = head,head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast=fast.next
            slow.next.next = temp
            slow = temp
            
            
        
