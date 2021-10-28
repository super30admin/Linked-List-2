'''
Time Complexity: O(n)
Space Complexity: O(1)
'''
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        list1=headA
        lenList1=0
        while list1:
            list1=list1.next
            lenList1+=1
        
        list2=headB
        lenList2=0
        while list2:
            list2=list2.next
            lenList2+=1
        
        diff=abs(lenList1 - lenList2)
        if lenList1>lenList2:
            while diff>0:
                headA=headA.next
                diff-=1
        else:
            while diff>0:
                headB=headB.next
                diff-=1
        
        while headA and headB:
            if headA==headB:
                return headA
            headA=headA.next
            headB=headB.next
        return None