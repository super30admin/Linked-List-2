
# LC - 160. 
# Intersection of Two Linked Lists

# Time Complexity : O(n+m) n,m no. of nodes in the linked list A, B
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        
        p1=headA
        p2=headB
        
        while p1!=p2:
            
            if p1==None:
                p1=headB
            else:
                p1=p1.next
                
            
            
            if p2==None:
                p2=headA
            else:
                p2=p2.next
                
        
        return p1
            