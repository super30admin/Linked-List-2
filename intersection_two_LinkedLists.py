""" Explanation: The getIntersectionNode function first calculates the lengths of both linked lists.
    It then moves the pointer of the longer list ahead by the difference in lengths.
    Finally, it iterates through both lists simultaneously until it finds the intersection point or 
    reaches the end (no intersection).
    Time Complexcity: O(n)
    Space Complexcity: O(1)
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        def getLength(node):
            length = 0
            while node:
                length += 1
                node = node.next
            return length

        lenA, lenB = getLength(headA), getLength(headB)

        # Move the pointer of the longer list ahead by the difference in lengths
        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        # Iterate through both lists simultaneously until intersection point is found
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA  # Return the intersection point or None if no intersection
        