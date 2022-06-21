# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None: return head
        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        head2=self.reverse(slow.next)
        slow.next=None
        # print(head,head2)
        slow=head
        fast=head2
        while fast!=None:
            temp=slow.next
            slow.next=fast
            slow=temp
            temp=fast.next
            fast.next=slow
            fast=temp
        return head
    def reverse(self, head: Optional[ListNode]):
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
            
        
        