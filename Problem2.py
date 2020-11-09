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
            
        if head is None or head.next is None:
            return True
        slow=head
        fast=head
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
        
        curr=slow
        prev=None
        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        
        first=head
        second=prev
        while second.next:
            temp=first.next
            first.next=second
            first=temp
            temp=second.next
            second.next=first
            second=temp
        
            
        
            
        