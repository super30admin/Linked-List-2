#Time Complexity : O(n)
#Space Complexity : O(1)
class Solution:
    def intersection(self, currA, currB):
        while(currA):
            if (currA == currB):
                return currA
            currA = currA.next
            currB = currB.next
        return None
        
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        curr = headA
        lenA = 0
        lenB = 0
        while(curr):
            lenA += 1
            curr = curr.next
        
        curr = headB
        while(curr):
            lenB += 1
            curr = curr.next
        if lenA >= lenB:
            curr = headA
            for i in range(lenA-lenB):
                curr = curr.next
            return self.intersection(curr,headB)
        else:
            curr = headB
            for i in range(lenB-lenA):
                curr = curr.next
            return self.intersection(headA, curr)
