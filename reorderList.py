# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


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
        """
        Made sense after going to class
        3 things:
            - Find middle of LL
            - Reverse from mid -> end
            - Merge 
        """
        if not head or not head.next:
            return 
        slow = head
        fast = head
        
        while fast.next and fast.next.next:
            slow = slow.next 
            fast = fast.next.next 
            
        #reverse from second half to end
        def reverse(head):
            prev = None
            curr = head 
            fast = head.next 
            while fast:
                curr.next = prev 
                prev = curr 
                curr = fast 
                fast = fast.next 
            curr.next = prev 
            return curr
        
        fast = reverse(slow.next)
        #merge
        slow.next = None
        slow = head 
        while fast:
            temp = slow.next 
            slow.next = fast 
            fast = fast.next
            slow.next.next = temp 
            slow = temp
            
        
        
        
        