# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    """Time complexity-O(m+n)
    Space complexity-O(1)"""
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        listA=headA
        listB=headB
        lenA=0
        lenB=0
        while listA:
            lenA+=1
            listA=listA.next
        while listB:
            lenB+=1
            listB=listB.next
        while lenA>lenB:
            headA=headA.next
            lenA-=1
        while lenA<lenB:
            headB=headB.next
            lenB-=1
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headA
            
            
            
        
        