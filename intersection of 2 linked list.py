# // Time Complexity : O(n+m) where n and m are the length of linked lists
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def getIntersectionNode(self, headA, headB):
        
        # set both pointers at the heads of both linked lists 
        a = headA
        b = headB
        
        # loop ends at the intersection
        while a != b:
            if not a:
                a = headB
            else:
                a = a.next
                
            if not b:
                b = headA
            else:
                b = b.next
                
        return a