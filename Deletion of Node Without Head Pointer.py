# Time: O(1)
# Space: O(1)

# The current node is given that should be deleted (head is not given)

# We do not have access to the previous node of the node that should be deleted
# So first replace the value of the next node with the current node
# and then assign the node.next.next to node.next
class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next