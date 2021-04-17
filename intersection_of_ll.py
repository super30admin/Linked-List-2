# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None:
            return None
        lenA=lenB=0
        curr=headA
        while(curr.next!=None):
            lenA+=1
            curr=curr.next
        curr=headB
        while(curr.next!=None):
            lenB+=1
            curr=curr.next
        while(lenA>lenB):
            lenA-=1
            headA=headA.next
        while(lenB>lenA):
            lenB-=1
            headB=headB.next
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headA