## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        length_headA = 0 
        length_headB = 0
        startA = headA
        while(startA):
            length_headA+=1
            startA = startA.next
        startB = headB
        while(startB):
            length_headB+=1
            startB = startB.next
        if length_headA > length_headB:
            loop_count = length_headA - length_headB 
            while(loop_count>0):
                headA = headA.next
                loop_count-=1
        else:
            loop_count = length_headB - length_headA
            while(loop_count>0):
                headB = headB.next
                loop_count-=1
        while(headB):
            if headA == headB:
                return headA
            headB= headB.next
            headA = headA.next
        return headA