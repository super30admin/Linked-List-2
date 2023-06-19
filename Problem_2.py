"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

First finding the middle point of the linked list in order to break it into two parts
then reversing the second half of the linked list to make traversing possible from both the ends
then ietarting from both the ends, saving the next links, changing the current links, and updating the current to next links 

"""

# reorder list

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
        if head==None or head.next==None:
            return head
        # finding the middle point of linked list
        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        
        
        head_l2=slow.next
        slow.next=None

        # reversing the other half of linked list

        prev=None
        curr=head_l2

        while curr!=None:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp

        # iterating from both the ends

        first,second=head,prev

        # as second half of linked list has lower length than first, hence will become None before first part does
        while second:
            temp1=first.next
            temp2=second.next
            first.next=second
            second.next=temp1
            first=temp1
            second=temp2
        