# TC: O(N) 
# SC: O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = 0
        lenB = 0
        
        curr = headA
        while curr:
            curr = curr.next
            lenA += 1
        
        curr = headB
        while curr:
            curr = curr.next
            lenB += 1  
        
        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
