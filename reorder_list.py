# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head is None:
            return
        slow=fast=head
        while(fast.next is not None and fast.next.next is not None):
            slow=slow.next
            fast=fast.next.next
        head2=slow.next
        slow.next=None
        prev=None
        curr=head2
        temp=None
        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        head2=prev
        while head2:
            temp=head.next
            temp2=head2.next
            head.next=head2
            head2.next=temp
            head=temp
            head2 = temp2