# // Time Complexity : O(n+m) where n,m stand for length of the two lists 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        m = n = 0
        p1 = headA
        p2 = headB
        
        while p1:
            m += 1
            p1 = p1.next
    
        while p2:
            n += 1
            p2 = p2.next
        
        p1 = headA
        p2 = headB
        diff = abs(m-n)
        if m > n:
            while diff:
                p1 = p1.next
                diff -= 1
        elif n > m:
            while diff:
                p2 = p2.next
                diff -= 1
        
        while p1 and p2 and p1 != p2:
            
            p1 = p1.next
            p2 = p2.next
            
        if p1 and p2: return p1
        
        return None