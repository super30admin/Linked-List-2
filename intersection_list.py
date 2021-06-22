# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def usingHashset(self, headA, headB):
        #         Initialzing hashset
        hashset = set()

        ca = headA
        cb = headB

        #         add all elements in first list in hashset
        while ca:
            hashset.add(ca)
            ca = ca.next
        #         while adding elements in list b we will check if current node is present in hashset if already present return that node or else add it to set
        while cb:
            if cb in hashset:
                return cb
            else:
                hashset.add(cb)
                cb = cb.next

    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def usingPointers(self, headA, headB):
        #         usinh two pointers we will check if both nodes at current pointer is same if not move by 1 x speed and if any one of the pointer hits to null then assign that pointer to head of another list and move forward
        #  we will meet the pointer at intersection point definately
        ca = headA
        cb = headB

        #         Base Condition
        while ca != cb:

            if not ca:
                ca = headB
            else:
                ca = ca.next
            if not cb:
                cb = headA
            else:
                cb = cb.next

        return cb

    def getIntersectionNode(self, headA, headB):

        return self.usingHashset(headA, headB)
        return self.usingPointers(headA, headB)

        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
