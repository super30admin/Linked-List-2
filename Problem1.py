# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

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
        fast=head
        slow=head
        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next

        prev=None
        curr=slow.next
        while curr!=None:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        slow.next=prev

        slow.next=None
        fast=prev
        slow=head

        while fast!=None:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
        

        
            
        

            
            


        
            
