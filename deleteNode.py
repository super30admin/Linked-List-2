class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val 
        temp = node.next.next 
        node.next.next = None
        node.next = temp
        
