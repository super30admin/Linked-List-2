# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#Time Complexity : O(m+n)
#Space Complexity : O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        currA = headA
        while currA != None:
            currA = currA.next
            lenA +=1
        lenB = 0
        currB = headB
        while currB != None:
            currB = currB.next
            lenB +=1
        if lenA == 0 and lenB == 0 : return None
        p1 = headA
        p2 = headB
        while lenA > lenB:
            p1 = p1.next
            lenA -=1
        while lenB > lenA:
            p2 = p2.next
            lenB -=1
        
        while p1 != p2:
            p1 = p1.next
            p2 = p2.next
        
        return p1

