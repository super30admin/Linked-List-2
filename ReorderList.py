# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """This is done by first finding middle element and then 
    reversing the second half of the array and
    merging the first half and second half consecutively
    Time complexity-O(n+n+n) i.e O(n)
    Space Complexity-O(1)"""
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow=head
        fast=head
        if not head or not head.next:
            return head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        fast=self.reverse(slow.next)
        slow.next=None
        slow=head
        while fast:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
        
    def reverse(self, head):
        prev=None
        slow=head
        fast=head.next
        while fast:
            slow.next=prev
            prev=slow
            slow=fast
            fast=fast.next
        slow.next=prev
        return slow
        