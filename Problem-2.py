#Time Complexity :O(n)
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
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
        if(head==None or head.next==None):
            return head
        
        #mid
        fast=head
        slow=head
        
        while(fast!=None and fast.next!=None):
            fast=fast.next.next
            slow=slow.next
            
        curr=slow.next
        slow.next=None
        strt=head
        prev=None
        #reverse
        while(curr!=None):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        
        snd=prev
        mhead=strt
        while(strt!=None and snd!=None):
            temp=strt.next
            strt.next=snd
            temp2=snd.next
            snd.next=temp
            strt=temp
            snd=temp2
        
        return mhead
        
        