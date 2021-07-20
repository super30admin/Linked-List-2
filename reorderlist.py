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
        def reverse(temp:TreeNode):
            prev=None
            curr=temp
            while curr!=None:
                temp1=curr.next
                curr.next=prev
                prev=curr
                curr=temp1
            return prev
        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        fast=reverse(slow.next)
        slow.next=None
        slow=head
        
        while slow!=None and fast!=None:
            temp1=slow.next
            temp2=fast.next
            slow.next=fast
            fast.next=temp1
            fast=temp2
            slow=temp1
    
        
        #print(head)    
        
        
    
                