class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
        
        # simple question, copying next nodes value in the node to be delated, and then point node.next  to node.next.next. tc and sc is constant
