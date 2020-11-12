# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
'''// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

'''
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow=head
        fast=head
        
        
        while(fast!=None and fast.next!=None):
            temp=slow
            slow=slow.next
            fast=fast.next.next
        
        temp.next=None
        second=self.reverse(slow)
        
        
        prev=ListNode(-1)
        current=head
        fast=current.next
        slow=second
        
        while(fast!=None ):
            
            
            prev.next=current
            current.next=slow
            slow=slow.next
            current.next.next=fast
            fast=fast.next
            
            
        
            
        
    def reverse(self,slow):
        
        prev=None
        current=slow
        
        while(current!=None):
            fast=current.next
            current.next=prev
            prev=current
            current=fast
            
        return prev
