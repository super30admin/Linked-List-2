'''
Time Complexity : O(n)
Space Complexity : O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countA = 0
        countB = 0
        a_ptr = headA
        b_ptr = headB

        while a_ptr != None:
            a_ptr = a_ptr.next
            countA += 1
        while b_ptr != None:
            b_ptr = b_ptr.next
            countB += 1
        a_ptr = headA
        b_ptr = headB
        while(countA < countB):
            b_ptr = b_ptr.next
            countB -= 1
        while(countA > countB):
            a_ptr = a_ptr.next
            countA -= 1
        while(a_ptr != b_ptr):
            a_ptr = a_ptr.next
            b_ptr = b_ptr.next
        return a_ptr
