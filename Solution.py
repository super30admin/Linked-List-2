"""
TC O(N)+O(N)+O(N) = O(N)
SC=0(1)


"""

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
            return 
        #find middle element 
        slow=head
        fast=head
        while fast.next and fast.next.next: #Time complexity O(N)
            slow=slow.next
            fast=fast.next.next
            
        #reverse the 2nd half of the list 
        fast=self.reversed(slow.next)  #0(N)
        slow.next=None
        slow=head
        while fast: #O(N)
            curr=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=curr
            slow=curr
        
    def reversed(self,head):
        prev=None
        curr=head
        fast=curr.next
        while(fast):
            curr.next=prev
            prev=curr
            curr=fast
            fast=fast.next
        curr.next=prev
        return curr