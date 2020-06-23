"""
// Time Complexity : in code
// Space Complexity : in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



// Your code here along with comments explaining your approach
"""


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        """
        Using extra space
        
        time : o(m+n)
        space : o(m+n)
        
        s = set() #create a set of all values in listA
        while headA:
            s.add(headA)
            headA = headA.next
            
        while headB and headB not in s: #iterate over listB until we find a node that exists in the set 
            headB = headB.next
            
        return headB
        """
        
        """
        optimized
        time : o(m+n)
        space : o(1)
        """
        cur = headA
        lenA = 0
        lenB = 0
        #find lengths of both the lists
        while cur:
            lenA += 1
            cur = cur.next
        
        cur = headB
        while cur:
            lenB += 1
            cur = cur.next
        #find a point in either of the lists from where they are of equal lengths    
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        #iterate over the lists together to find the common point 
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA
        
        
        