# Time Complexity :O(m + n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: The code finds the intersection node of two linked lists, if one exists. It first counts the lengths of both lists, then advances the pointer of the longer list so that both pointers are aligned at the same distance from the end. Finally, it walks both pointers forward together until they meet at the intersection node (or None if no intersection).


# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countA = 0
        countB = 0

        currA = headA
        currB = headB

        while currA:
            countA += 1
            currA = currA.next
        
        while currB:
            countB += 1
            currB = currB.next
        
        currA = headA
        currB = headB

        while countA > countB:
            currA = currA.next
            countA -= 1
        
        while countB > countA:
            currB = currB.next
            countB -= 1
        
        while currA != currB:
            currA = currA.next
            currB = currB.next
        
        return currA
