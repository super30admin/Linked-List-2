#TC: O(m+n) SC:O(1)
#two pointers

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None

        A=headA
        lenA=0
        while A!=None:
            lenA+=1
            A=A.next

        B=headB
        lenB=0
        while B!=None:
            lenB+=1  
            B=B.next  

        while lenA>lenB:
            headA=headA.next
            lenA-=1

        while lenB>lenA:
            headB=headB.next
            lenB-=1

        while headA != headB:
            headA=headA.next
            headB=headB.next

        return headA    
