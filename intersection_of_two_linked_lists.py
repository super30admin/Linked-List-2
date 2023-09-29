# Time Complexity: O(n+m) where n and m is the number of nodes
# Space Complexity:  O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        curr = headA
        while (curr != None):
            lenA += 1
            curr = curr.next
        curr = headB
        while (curr != None):
            lenB += 1
            curr = curr.next
        if lenA > lenB:
            while(lenA != lenB):
                headA = headA.next
                lenA -=1
        else:
            while(lenA != lenB):
                headB = headB.next
                lenB -=1
        while(headB != None):
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None
