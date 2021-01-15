# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        """
        have two pointers 1 for headA and another for headB
        keep iterating  until the two nodes intersect (when it ==)
        """

        if headA is None or headB is None:
            return None
        
        p1 = headA
        p2 = headB
        
        while p1 != p2:
            p1 = p1.next 
            p2 = p2.next 
            
            if p1 == p2:
                return p1 
            
            if p1 is None:
                p1 = headB
            if p2 is None:
                p2 = headA
            
        return p1