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
        middle=self.get_middle(head)
        
        curr=middle
        prev=None
        
        while curr is not None:
            n=curr.next
            curr.next=prev
            prev=curr
            curr=n
            
        
        first,second=head,prev
        
        while second.next:
            first.next,first=second,first.next
            second.next,second=first,second.next
        
    def get_middle(self,head):
        slow=head
        fast=head
        
        while fast is not None and fast.next is not None:
            slow=slow.next
            fast=fast.next.next
            
        return slow