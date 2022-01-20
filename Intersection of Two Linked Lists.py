# Time Complexity :
# TC: O(N+M) --> N and M are length of two LLs

# Space Complexity :
# SC: O(1)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# First i have computed the length of both ll
# After that i have moved the pointer of larger LL to the node from where length of
# this larger LL is equal to length of smaller LL
# Then i moved pointers of both LL until both are pointing to same node and returned this node.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # TC: O(N+M) --> N and M are length of two arrays
        # SC: O(1)
        
        p1 = headA
        p2 = headB
        
        len1 = 1
        len2 = 1
        
        while (p1.next != None):
            p1 = p1.next
            len1 += 1
        
        while (p2.next != None):
            p2 = p2.next
            len2 += 1
            
        p1 = headA
        p2 = headB
            
        while (len1 > len2):
            p1 = p1.next
            len1 -= 1
            
        while (len2 > len1):
            p2 = p2.next
            len2 -= 1
            
        while (p1 != p2):
            p1 = p1.next
            p2 = p2.next
            
        return p1