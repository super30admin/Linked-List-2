# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        curr=headA
        lenA=0
        while curr!=None:
            curr=curr.next
            lenA+=1
        lenB=0
        curr=headB
        while curr!=None:
            curr=curr.next
            lenB+=1
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
            