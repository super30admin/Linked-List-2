# // Time Complexity :O(n) 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




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
        
        slow=head
        fast=head
        
        while fast.next is not None and fast.next.next is not None:
            
            slow=slow.next
            fast=fast.next.next
        
        
        fast=self.reverse(slow.next)
        slow.next=None
        slowh=head
        while fast:
            print(slowh.val)
            print(fast.val)
            
            temp=slowh.next
            slowh.next=fast
            fast=fast.next
            slowh.next.next=temp
            slowh=temp
        
    def reverse(self,root):
        if root is None:
            return
        prev=None
        curr=root
        last=root.next
        
        while curr.next:
            
          
            curr.next=prev
            prev=curr
            curr=last
            last=last.next
        curr.next=prev
        return curr