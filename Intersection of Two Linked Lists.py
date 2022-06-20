""""// Time Complexity : O(m+n)
m=lenA
n=lenB
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""





# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        temp1 = headA
        lenA = 0
        while temp1 != None:
            temp1 = temp1.next
            lenA += 1

        temp2 = headB
        lenB = 0
        while temp2 != None:
            temp2 = temp2.next
            lenB += 1

        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA

