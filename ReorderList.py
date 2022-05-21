#Time complexity: O(n)
#Space complexity: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head) -> None:
        fast,slow=head,head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        prev=None
        while slow:
            nxt=slow.next
            slow.next=prev
            prev=slow
            slow=nxt
        while prev.next:
            tmp=head.next
            tmp1=prev.next
            head.next=prev
            head=tmp
            prev.next=head
            prev=tmp1
        