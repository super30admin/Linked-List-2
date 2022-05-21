#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        prev=None
        while node.next:
            prev=node
            node.val=node.next.val
            node=node.next
        prev.next=None