# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        l1=0
        l2=0
        hA=headA
        hB=headB
        while(hA!=None):
            l1+=1
            hA=hA.next
        while(hB!=None):
            l2+=1
            hB=hB.next
        hA=headA
        hB=headB
        d=abs(l1-l2)
        if l1>l2:
            while(d>0):
                d-=1
                hA=hA.next
        elif l2>l1:
            while(d>0):
                d-=1
                hB=hB.next
        while(hA!=None and hB!=None):
            if hA==hB:
                return hA
            hA=hA.next
            hB=hB.next
        return None
        #Time O(n)
        #Space O(1)
            
