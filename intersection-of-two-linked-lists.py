# Time: O(n+m)
# Space: O(1)

class Solution:
    def getLength(self, head: ListNode):
        length = 0
        while(head.next != None):
            length += 1
            head = head.next
        return length

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = self.getLength(headA)
        lenB = self.getLength(headB)

        while(lenA > lenB):
            lenA -= 1
            headA = headA.next
        while(lenB > lenA):
            lenB -= 1
            headB = headB.next
        
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
        
        