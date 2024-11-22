# The code defines a getIntersectionNode method to find the intersection node of two singly linked lists.
# If the two lists intersect, the method returns the node where they merge; otherwise, it returns None.

# Approach:
#   - Use two pointers, 'one' and 'two', to traverse the two linked lists.
#   - If the lists intersect, both pointers will eventually meet at the intersection node.
#   - If the lists do not intersect, both pointers will reach the end (None) simultaneously.

# Steps:
#   - Initialize 'one' to headA (the start of the first list) and 'two' to headB (the start of the second list).
#   - Traverse both lists simultaneously:
#       - Move 'one' to the next node in list A.
#       - Move 'two' to the next node in list B.
#       - If 'one' reaches the end of list A, reset it to the head of list B.
#       - If 'two' reaches the end of list B, reset it to the head of list A.
#   - Continue this process until 'one' equals 'two'.
#       - If the lists intersect, 'one' and 'two' will meet at the intersection node.
#       - If the lists do not intersect, both pointers will eventually become None.

# Final Result:
#   - Return 'one', which will either point to the intersection node or None if there is no intersection.

# TC: O(m + n) - Both pointers traverse at most m + n nodes, where m is the length of list A and n is the length of list B.
# SC: O(1) - The space complexity is constant, as no additional data structures are used.


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        one = headA
        two = headB

        while one != two:
            one = headB if one is None else one.next
            two = headA if two is None else two.next
        return one