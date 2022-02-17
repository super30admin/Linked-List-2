#O(m + n) time and O(1) space solution
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        current = headA
        while(current != None):
            current = current.next
            lenA += 1
        
        current = headB
        while(current != None):
            current = current.next
            lenB += 1
        
        while(lenA > lenB):
            headA = headA.next
            lenA -= 1
        
        while(lenB > lenA):
            headB = headB.next
            lenB -= 1
        
        while(headA != headB):
            headA = headA.next
            headB = headB.next
        
        return headA
        
        