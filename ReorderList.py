#// Time Complexity : O(n)
#// Space Complexity : O(h)
#// Did this code successfully run on Leetcode :yes

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
        if(head==None or head.next==None):
            return head
        slow=head
        fast=head
        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next

        reverse=self.reverselist(slow.next)
        slow.next=None
        fast=reverse
        slow=head
        while(fast!=None):
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
            
        
    def reverselist(self,head):
        if(head==None or head.next==None):
            return head
        reverse=self.reverselist(head.next)
        head.next.next=head
        head.next=None
        return reverse

        
        
        
        
        