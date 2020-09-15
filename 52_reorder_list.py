# S30 Big N Problem #52 {Medium}

# LC - 143. 
# Reorder List

# Time Complexity : O(n) n=no. of nodes in the linked list
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# using the fast and slow pointer concept, reach the mid point of the LL.
# from the mid point, make a separate LL. Reverse this LL.
# traverse these 2 LLs from their first position. add the node from the 2nd LL to the 1st LL alternatively. 

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
        
        if head is None:
            return None
        
        hare=head
        turtle=head
        
        while hare!=None and hare.next!=None :
            hare=hare.next.next
            turtle=turtle.next
            
        
        head2=turtle.next
        turtle.next=None

        head2=self.reverse(head2)
        
        root=head
        while head!=None and head2!=None:
            temp1=head.next
            temp2=head2.next
            head.next=head2
            head2.next=temp1
            head=temp1
            head2=temp2
            
        return root
            
        
    def reverse(self,head):
        
        p1=None
        p2=head
        
        while p2!=None:
            
            temp=p2.next
            p2.next=p1
            p1=p2
            p2=temp
        
        return p1
        