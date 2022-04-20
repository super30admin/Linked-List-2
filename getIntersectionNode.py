# Time complexity -> O(m+n)
# Space complexity -> O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None
        
        countA, countB = 0,0
        currA,currB = headA, headB
        
        while headA or headB:
            if headA:
                countA += 1
                headA = headA.next
                
            if headB:
                countB += 1
                headB = headB.next
                
        
        if countA > countB:
            while countA != countB:
                currA = currA.next
                countA -= 1
        else:
            while countB != countA:
                currB = currB.next
                countB -= 1
        
        while currA != currB:
            currA = currA.next
            currB = currB.next
            
        return currA