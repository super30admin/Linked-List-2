# Time Complexity : O(n+m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA=0
        lenB=0
        diff=0
        CurrA=headA
        CurrB=headB
        while(headA!=None):
            lenA+=1
            headA=headA.next

        while(headB!=None):
            lenB+=1
            headB=headB.next

        diff=abs(lenB-lenA)
        
        while diff!=0:
            if lenB>lenA:
                CurrB=CurrB.next
            if lenA>lenB:
                CurrA=CurrA.next 
            diff-=1

        while CurrA!=CurrB:
            CurrA=CurrA.next
            CurrB=CurrB.next

        return CurrA





