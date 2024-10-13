'''
    Time Complexity: O(m+n)
    Space Complexity: O(1)
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pta = headA
        ptb = headB
        firstTraversalA = True
        firstTraversalB = True

        while pta != ptb:
            if pta.next:
                pta = pta.next
            elif firstTraversalA:
                pta = headB
                firstTraversalA = False
            else: 
                return None

            if ptb.next:
                ptb = ptb.next
            elif firstTraversalB:
                ptb = headA
                firstTraversalB = False
            else: 
                return None

        return pta