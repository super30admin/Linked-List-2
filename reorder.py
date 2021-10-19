#TC:O(N)
#SC:O(1)
#Successfully ran on leetcode
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse_list(self,head):
        curr=head
        prev=None
        next=None

        while(curr):
            next=curr.next
            curr.next=prev
            prev=curr
            curr=next

        return prev

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #Mid point
        slow=head
        fast=head

        while(fast and fast.next):
            slow=slow.next
            fast=fast.next.next

        #Reverse 2nd Half of the list
        p2=self.reverse_list(slow.next)
        slow.next=None

        #Combine the two lists
        p1=head
        while(p2 and p1):
            p1N=p1.next
            p2N=p2.next

            p1.next=p2
            p2.next=p1N

            p1=p1N
            p2=p2N



  
