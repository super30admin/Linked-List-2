# // Time Complexity : O(m+n) or max(m,n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# 1. get length from both routes
# 2. run pointer till difference between length is 0 of larger route
# 3. iterate until both nodes are same

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA == None or headB == None: return None
        cur = headA
        numA, numB = 0,0
        # route 1
        while cur:
            numA +=1
            cur = cur.next
        cur = headB
        #route 2
        while cur:
            numB += 1
            cur = cur.next
        # if route 2 is greater bring pointer till dif
        while numA < numB:
            headB = headB.next
            numB -= 1
        
        while numA > numB:
            headA = headA.next
            numA -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA
            
            
            