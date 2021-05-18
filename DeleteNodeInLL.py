# TC: O(1) since we are accessing only the next node. 
# SC: O(1) since we do not use any extra space. 

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
