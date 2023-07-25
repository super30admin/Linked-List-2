# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    # Time Complexity:O(n)
    # Space Complexity:No space
    def getIntersectionNode(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        def get_length(node):
            length = 0
            while node:
                length += 1
                node = node.next
            return length

        lenA = get_length(headA)
        lenB = get_length(headB)

        diff = abs(lenA - lenB)

        longer_list = headA if lenA > lenB else headB
        shorter_list = headB if lenA > lenB else headA

        for i in range(diff):
            longer_list = longer_list.next

        while longer_list and shorter_list:
            if longer_list == shorter_list:
                return longer_list

            longer_list = longer_list.next
            shorter_list = shorter_list.next

        return None
