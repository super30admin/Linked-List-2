#Time: O(n)
#Space: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA and not headB:
            return None
        currA= headA
        currB= headB
        lena=1
        lenb=1
        while currA.next is not None:
            lena = lena + 1
            currA= currA.next
        while currB.next is not None:
            lenb = lenb + 1
            currB = currB.next
        
        currA= headA
        currB= headB
        while(lena > lenb):
            currA= currA.next
            lena -=1
        while(lena < lenb):
            currB= currB.next
            lenb -=1
        while( currA != currB):
            currA = currA.next
            currB = currB.next
        return currA
        
        
