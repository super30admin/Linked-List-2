# // Time Complexity :O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this:no


# // Your code here along with comments explaining your approach
# Brute force owuld aded verything into list , get count find mid then change values, other optimized method would be find mid by slow and fast pointers, reverse second halp and then merger
# both lls

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
        slow,fast =head ,head # this is to find mid point in linkedlist
        while(fast.next and fast.next.next):
            slow=slow.next
            fast=fast.next.next
        def reverseLL(head):
            prev=None
            curr=head
            while(curr):
                nxt=curr.next
                curr.next=prev
                prev=curr
                curr=nxt
            return prev
        head2=reverseLL(slow.next)
        slow.next=None
        # print("h1")
        
        head1=head
        
        while(head2  ):
            
            print(head2.val)
            t1,t2=head1.next,head2.next
            # print(f"h1 {head1.val},h2 {head2.val},  {t1}")
            head1.next=head2
            head2.next=t1
            head1=t1
            # print(head1==None, head1)
            head2=t2
        return head

        
