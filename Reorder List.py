# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
"""
Time complexity= O(n)
Space complexity=O(1)
"""
class Solution:
    def reverse(self,head):
        prev=None
        curr=head
        fast=head.next
        while fast!=None:
            curr.next=prev
            prev=curr
            curr=fast
            fast=fast.next
        curr.next=prev
        return curr


    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #find middle of LL
        if (head==None or head.next==None):
            return
        slow=head
        fast=head
        while(fast.next!=None and fast.next.next!=None): #for odd and even length respectively
            slow=slow.next
            fast=fast.next.next
        #slow will be at middle of LL so start of 2nd half is slow.next

        #reverse 2nd half
        fast= self.reverse(slow.next)
        slow.next=None #put last node of 1st part to null so we get second list as seperate list
        slow=head
        #merge two linked list
        while fast!=None:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
