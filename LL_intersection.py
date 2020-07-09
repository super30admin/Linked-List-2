# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA, lenB = 0,0
        curr = headA
        while curr:
            curr = curr.next
            lenA+=1
        curr = headB
        while curr:
            curr = curr.next
            lenB+=1
        while lenA>lenB:
            headA=headA.next
            lenA-=1
        while lenB>lenA:
            headB = headB.next
            lenB-=1
        while headA!=headB:
            headA=headA.next
            headB = headB.next
        return headB

#time complexity - O(m+n) where m and n are the lengths of linked lists 1 and 2 respectively

#space complexity - O(1) as no auxillary data structures have been used

#all test cases passed