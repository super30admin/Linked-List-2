class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA=0
        lenB=0
        curr=headA
        while(curr):
            lenA+=1
            curr=curr.next
        curr=headB
        while(curr):
            lenB+=1
            curr=curr.next
        while lenA>lenB:
            lenA-=1
            headA=headA.next
        while lenB>lenA:
            lenB-=1
            headB=headB.next
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headA

#Time-Complexity: O(m+n)
#Space-Complexity: O(1)  as no extra space is used