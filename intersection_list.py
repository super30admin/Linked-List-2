# O(N + M) TIME AND O(1) SPACE WHERE N IS LEN(A) AND M IS LEN(B) 
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = self.findLength(headA)
        lenB = self.findLength(headB)
        p1 = headA
        p2 = headB
        if lenA > lenB:
            diff = lenA - lenB
            while diff > 0 :
                p1 = p1.next
                diff -= 1
        else:
            diff = lenB - lenA
            while diff > 0 :
                p2 = p2.next
                diff -= 1
                
        while p1 is not None and p2 is not None and p1 != p2:
            p1 = p1.next
            p2 = p2.next
        
        return p1
                
    
    def findLength(self,head):
        p = head
        length = 0
        while p is not None:
            p = p.next
            length += 1
        return length