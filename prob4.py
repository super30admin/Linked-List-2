# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if(headA == None or headB == None):
            return None
        cur = headA
        lenA = 0
        lenB = 0
        while(cur != None):
            cur = cur.next
            lenA += 1
        cur = headB
        while(cur != None):
            cur = cur.next
            lenB += 1
        while(lenA < lenB):
            headB = headB.next
            lenB -= 1
        while (lenB < lenA):
            headA = headA.next
            lenA -= 1
        
        while(headA != headB):
            headA= headA.next
            headB = headB.next
        
        return headA
        
 