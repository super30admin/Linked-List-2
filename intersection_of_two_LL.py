class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        countA = 0
        currA = headA
        while currA!=None:
            currA = currA.next
            countA+=1

        countB = 0
        currB = headB
        while currB!=None:
            currB = currB.next
            countB+=1
            
        diff = abs(countA-countB)
        while diff!=0:
            if countA>countB:
                headA = headA.next
                diff-=1
            else:
                headB = headB.next
                diff-=1
        while headA!=headB:
            headA=headA.next
            headB = headB.next
        if headA and headB:
            return headA