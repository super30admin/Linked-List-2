"""
Approach: maintain 2 pointers, 1 on each linked list such that they start from the nodes on each linked list as of to
meet the intersection point at the same time.

TC: O(n)
SC: O(1)

"""
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None

        len_a = 1
        len_b = 1

        node_a = headA
        node_b = headB

        while node_a.next:
            node_a = node_a.next
            len_a += 1

        while node_b.next:
            node_b = node_b.next
            len_b += 1

        node_a = headA
        node_b = headB

        if len_b > len_a:
            for _ in range(len_b - len_a):
                node_b = node_b.next
        elif len_a > len_b:
            for _ in range(len_a - len_b):
                node_a = node_a.next

        while node_a and node_b:
            if node_a == node_b:
                return node_a
            node_a = node_a.next
            node_b = node_b.next
        return None