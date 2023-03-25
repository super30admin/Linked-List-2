# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :no
# Your code here along with comments explaining your approach
# find the mid of linkedlist, reverse the second half and merge bith the lists
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
        fast=head.next
        head1=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        sec_head=slow.next
        slow.next=None #breaking the list into two lists
        #reverse second list
        prev =None
        while sec_head:
            tmp=sec_head.next
            sec_head.next=prev
            prev=sec_head
            sec_head=tmp
        head2=prev
        while head2:
            tmp1,tmp2=head1.next,head2.next
            head1.next=head2
            head2.next=tmp1
            head1 = tmp1
            head2 = tmp2
        

        
            
        