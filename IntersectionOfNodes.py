   ----------------------Intersection of  in a List--------------------------------------   
# Time Complexity : O(M+N) M is the nodes in first LL, N is the nodes in the second LL
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I am planning to eliminate the difference  of nodes between 2 LL. So I am traversing bothe linkedlists at the same time and
#when ever I am encountering None I am assigning that pointer to the start of other LL. so that the difference will be eliminated.
#Once the difference eliminated, I will traverse both LL and reach the intersection.

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        
        curA = headA
        curB = headB
        
        while curA!=curB:
            if curA != None:
                curA = curA.next
            else:
                curA = headB
            
            if curB !=None:
                curB = curB.next
            else:
                curB = headA
        
        return curA