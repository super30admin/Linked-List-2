// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        if(head==None or head.next==None):
            return
        
        ##Finding Middle
        slow=head
        fast=head
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
        ## reversing the second half
        fast=self.reverse(slow.next)
        slow.next=None
        slow=head
        ##Merging two list
        slow=head
        while(slow!=None and fast!=None):
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
            
            
            
    def reverse(self,head):
        prev=None
        curr=head
        fast=head.next
        while(fast!=None):
            curr.next=prev
            prev=curr
            curr=fast
            fast=fast.next
        curr.next=prev
        return curr
        
