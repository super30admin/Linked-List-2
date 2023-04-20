# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
This problem is solved by obtaining the length of both the linked lists and then traversing the 
longer list until the lengths are equal. Once that is done, we just traverse the two lists in tandem
 until we find the intersection node.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:
            return headA

        curr = headA
        lenA = 0
        while curr != None:
            lenA += 1
            curr = curr.next

        curr = headB
        lenB = 0

        while curr != None:
            lenB +=1
            curr = curr.next

        while lenA >lenB:
            headA = headA.next
            lenA -=1

        while lenB > lenA:
            headB = headB.next
            lenB -=1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
