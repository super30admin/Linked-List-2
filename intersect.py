def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
    countA=0
    countB=0
    currA=headA
    currB=headB
    while currA:
        countA+=1
        currA=currA.next
    while currB:
        countB+=1
        currB=currB.next

    while countA>countB:
        headA=headA.next
        countA-=1

    while countB>countA:
        headB=headB.next
        countB-=1
    
    while headA!=headB:
        headA=headA.next
        headB=headB.next
    
    return headA
    
    
