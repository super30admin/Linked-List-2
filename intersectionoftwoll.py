# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        temp1=headA
        temp2=headB
        m,n=0,0
        while temp1!=None:
            m+=1
            temp1=temp1.next
            
        while temp2!=None:
            n+=1
            temp2=temp2.next
        if m<n:
            headA,headB=headB,headA
        count=abs(n-m)
        for i in range(count):
            headA=headA.next
            
        while headA!=None or headB!=None:
            if headA==headB:
                return headA
            headA=headA.next
            headB=headB.next
        return None
            
                
            
            