#Time Complexity : O(n) where n is the number of elements
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        
        if not head:
            return 
        slow=head
        fast=head
        
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
            
        
        mid=slow            
        
        prev=None
        next=None
        while mid:
            next=mid.next
            mid.next=prev
            prev=mid
            mid=next
        
        first=head
        second=prev
        
        #print(prev)
        
        while second.next:
            tmp=first.next
            first.next=second
            first=tmp
            
            tmp=second.next
            second.next=first
            second=tmp
  
        return head