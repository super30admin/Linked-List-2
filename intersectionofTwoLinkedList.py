# Time Complexity : O(n+m) n = size of first linkedlist and m = size of second linkedlist
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
1. traverse 2 pointer in both linkedlist
2. End of both of linked list add the other linkedlist
"""

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB: return None
        pa = headA
        pb = headB
        while (pa != pb):
            if pa!=None:
                pa=pa.next
            else: 
                pa = headB
            if pb!=None:
                pb=pb.next
            else:
                pb = headA
        
        return pa