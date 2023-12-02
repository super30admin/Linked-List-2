# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head.next==None:
            return head
        slow=head
        fast=head.next

        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next

        fast = slow.next
        slow.next = None

        tempF=fast
        prev=None
        while tempF:
            temp=tempF
            tempF=tempF.next
            temp.next=prev
            prev=temp

        fast = prev

        tempB=head
        while tempB and fast:
            temp=tempB.next
            tempB.next = fast
            fast = fast.next
            tempB.next.next = temp
            tempB=temp




        