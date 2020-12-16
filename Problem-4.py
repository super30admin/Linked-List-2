# Intersection of two linked lists

# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, Runtime: 160 ms and Memory Usage: 29.4 MB 
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using two pointers approach, Keeping pointer A at start of A and 
keeping ponter B at start of B. Traversing and comparing the list one node at a time 
till it reaches end. Since if it is intersecting it will return the result.


"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if(headA==None or headB==None): # Edge Case
            return None
        A_p=headA
        B_p=headB
        
        while(A_p is not B_p):
            if A_p is None:
                A_p=headB 
            else:
                A_p=A_p.next
            if B_p is None:
                B_p=headA
            else:
                B_p=B_p.next
                
        return A_p