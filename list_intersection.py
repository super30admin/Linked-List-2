# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# We start 2 pointers at both heads and move them forward when one pointer 
# reaches null I send it to other head and when they are equal we stop

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        p1 = headA
        p2 = headB
        switchedA = False
        switchedB = False
        
        while p1 and p2 and p1 != p2:
            p1 = p1.next
            p2 = p2.next
            if not p1 and not switchedA:
                p1 = headB
                switchedA = True
                
            if not p2 and not switchedB:
                p2 = headA
                switchedB = True
                
        return p2 if p1 else p1