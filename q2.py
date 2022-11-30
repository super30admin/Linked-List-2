from typing import Optional
# Time Complexity : O(n), Where n is number of elements in the linked list
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothingv specific
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverse(self,head: Optional[ListNode])-> Optional[ListNode]:
        if(head== None or head.next==None):
            return head
        prev,pres,fut=None,head,head.next
        while(fut!=None):
            pres.next=prev#Here we just changing the links in the reverse direction
            prev=pres
            pres=fut
            fut=fut.next
        pres.next=prev#Here we adjusting the link at the last node in the linked list
            
        return pres
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if(head==None or head.next==None):
            return
        #Here we will divide the linked list wrt middle(That is lower median)
        fast=head
        slow=head
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
        
        fhalf=head
        shalf=slow.next
        slow.next=None
        #print(fhalf,shalf)
        
        #Reverese the second half of the list
        shalf=self.reverse(shalf)
        #print(fhalf,shalf)
        
        #Rearranging the linked list as per needs
        while(shalf!=None):
            temp=fhalf.next
            fhalf.next=shalf
            shalf=shalf.next
            fhalf.next.next=temp
            fhalf=temp
          
        