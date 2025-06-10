#Time Complexity: O(1)
#Space Complexity: O(1)


class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void
        """
        node.val = node.next.val
        node.next = node.next.next