class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1,l2 = headA,headB
        count1,count2 =0,0
        while(l1 != None):
            l1 = l1.next
            count1 += 1
        while (l2 != None):
            l2 = l2.next
            count2 += 1
        l1,l2 = headA,headB
        while(count2>count1):
            l2 = l2.next
            count2 -= 1
        while(count1>count2):
            l1 = l1.next
            count1 -=1
        while l1 and l2:
            if l1 == l2:
                return l1
            l1 = l1.next
            l2 = l2.next
        return None