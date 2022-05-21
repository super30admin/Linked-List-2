#Time complexity: O(n)
#Space complexity; O(1)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):
        lenA,lenB=0,0
        curr=headA
        while curr:
            lenA+=1
            curr=curr.next
        curr=headB
        while curr:
            lenB+=1
            curr=curr.next
        while lenA>lenB:
            headA=headA.next
            lenA-=1
        while lenB>lenA:
            headB=headB.next
            lenB-=1
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headA
        