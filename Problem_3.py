# 160. Intersection of Two Linked Lists

# Code:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        size1 = 0 
        size2 = 0
        
        p = headA
        q = headB
        
        # Length of LL-1
        while p:
            size1+=1
            p = p.next
        
        # Length of LL-2
        while q:
            size2+=1
            q = q.next
        
        p = headA
        q = headB
        
        # Equalizing the start pointer 
        if size1>size2:
            while size1!=size2:
                p = p.next
                size1-=1
        else:
            while size1!=size2:
                q = q.next
                size2-=1
        
        # Checking for the equal val
        while p and q:
            if p==q:
                return p
            else:
                p = p.next
                q = q.next
        
        return None
            
                





# Time complexity: O(n) 
# Space complexity: O(1)
# Accepted on Leetcode: Yes.