# TC-O(n)
# SC-O(1)

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
        if head==None or head.next==None:
            return head
        slow=head
        fast=head

        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next

        head2=self.reverse(slow.next)
        slow.next=None

        # print(head)
        # print(head2)
        while(head!=None and head2!=None):
            temp=head.next
            head.next=head2
            head2=head2.next
            head.next.next=temp
            head=temp



    def reverse(self,root):
        prev=None
        current=root
        fast=root.next

        while(fast!=None):
            current.next=prev
            prev=current
            current=fast
            fast=fast.next
        current.next=prev

        return current