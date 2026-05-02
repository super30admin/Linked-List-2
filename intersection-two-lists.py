# time O(n), space O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # find lengths
        # move ptr of longer list until meets shorter
        # find when nodes equal

        lenA = 0
        curA = headA
        while curA:
            lenA+=1
            curA = curA.next 

        lenB = 0
        curB = headB 
        while curB:
            lenB+=1
            curB = curB.next 

        curA = headA
        while lenA > lenB:
            curA = curA.next 
            lenA-=1

        curB = headB 
        while lenB > lenA:
            curB = curB.next 
            lenB-=1

        while curA != curB:
            curA = curA.next 
            curB = curB.next 

        return curA