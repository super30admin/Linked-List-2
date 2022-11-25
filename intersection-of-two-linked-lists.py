#TC: O(max(m,n))
#SC: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA,lenB=0,0
        itrA,itrB=headA,headB
        while itrA and itrB: itrA=itrA.next; lenA+=1; itrB=itrB.next; lenB+=1
        while itrA: itrA=itrA.next; lenA+=1
        while itrB: itrB=itrB.next; lenB+=1

        itrA,itrB=headA,headB
        while lenA>lenB: itrA=itrA.next; lenA-=1
        while lenB>lenA: itrB=itrB.next; lenB-=1

        while itrA and itrB:
            if itrA==itrB: return itrA
            itrA=itrA.next; itrB=itrB.next
        return None