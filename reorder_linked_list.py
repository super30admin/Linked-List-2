# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self,root):
        prev=None
        cur=root
        while cur!=None:
            fwd=cur.next
            cur.next=prev
            prev=cur
            cur=fwd
        return prev


    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
            
        fast=self.reverse(slow.next)
        slow.next=None

        slow=head
        # print(slow)
        # print(fast)
        while fast!=None:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp

        return head