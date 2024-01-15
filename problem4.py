# Time Complexity : O(m + n), where m is the length of the first linked list (headA) and n is the length of the second linked list (headB)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes

# Definition for singly-linked list.
class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> [ListNode]:
        lenA = 0
        curr = headA
        while curr is not None:
            lenA += 1
            curr = curr.next

        lenB = 0
        curr = headB
        while curr is not None:
            lenB += 1
            curr = curr.next
        
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
