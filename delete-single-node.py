# Time Complexity: O(1)
# Space Complexity: O(1)
# Approach: We are simply overwriting the value of the next node in the given node and pointing the node's next pointer to next->next.

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next