# Problem 143. REORDER LIST
# TIME COMPELXITY: O(N) where N denotes the number of nodes that are there in the givne linked list as we are traversing it
# SPACE COMPLEXITY: O(1) as we are only using pointers in order to traverse the linked list

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        currentA = headA
        currentB = headB

        while currentA != currentB:
            currentA = currentA.next
            currentB = currentB.next

            if currentA is None and currentB is None:
                return None

            if currentA is None:
                currentA = headB

            if currentB is None:
                currentB = headA

        return currentA