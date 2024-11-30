"""
Time complexity: O(N)
Space complexity: O(1)
Compiled on leetcode: Yes
Difficulties faced: None
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        headASize = 0
        headBSize = 0
        
        currentNode = headA
        while currentNode is not None:
            headASize += 1
            currentNode = currentNode.next
        
        currentNode = headB
        while currentNode is not None:
            headBSize += 1
            currentNode = currentNode.next
            
        
        if headASize > headBSize:
            for i in range(headASize - headBSize):
                headA = headA.next
        else:
            for i in range(headBSize - headASize):
                headB = headB.next
        
        while headA is not None and headB is not None:
            if headA == headB:
                return headA
            else:
                headA = headA.next
                headB = headB.next
        return None  