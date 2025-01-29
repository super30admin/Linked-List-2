#Time Complexity = O(n + m)
#Space Complexity = O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        countA, countB = 0, 0
        currA, currB = headA, headB
        
        # Count length of both linked lists
        while currA:
            countA += 1
            currA = currA.next
        
        while currB:
            countB += 1
            currB = currB.next
        
        # Reset pointers
        currA, currB = headA, headB
        
        # Align both lists to the same starting point
        while countA > countB:
            currA = currA.next
            countA -= 1
        
        while countB > countA:
            currB = currB.next
            countB -= 1
        
        # Traverse together until intersection is found
        while currA != currB:
            currA = currA.next
            currB = currB.next
        
        return currA  # Either the intersection node or None
