# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Comments written while coding
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
        # 3 Steps
        #1. Find the mid
        # Using slow and fast for it
        slow,fast=head,head.next
        
        while fast!=None and fast.next!=None:
            slow=slow.next
            fast=fast.next.next
            
        #second half of the list
        second=slow.next
        
        #splitting the list
        slow.next=None
        prev=None
        
        #2. Reverse the second list
        while second:
            nxt=second.next
            second.next=prev
            prev=second
            second=nxt
            
            
        #3. Merge the both lists
        first,second=head,prev
        #Until any of them reaches null
        while second:
            #storing next of both in 2 variables
            temp1,temp2=first.next,second.next
            #Merging 
            first.next=second
            second.next=temp1
            #Moving the pointers
            first=temp1
            second=temp2