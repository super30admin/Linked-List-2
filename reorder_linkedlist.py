# Time Complexity : O(N) where N is number of nodes in the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        count = 1
        slow = head
        fast = head
        
        while fast.next is not None and fast.next.next is not None:
            count += 1
            slow = slow.next
            fast = fast.next.next
            
        if count <= 1:
            return
            
        end = self.reverse(slow.next)
        slow.next = None
        start = head
        while end is not None:
            t = start.next
            start.next = end
            end = end.next
            start.next.next = t
            start = start.next.next
                
    
    def reverse(self, node):
        prev = None
        curr = node
        lead = node.next
        
        while curr.next is not None:
            curr.next = prev
            prev = curr
            curr = lead
            lead = lead.next
            
        curr.next = prev
        
        return curr