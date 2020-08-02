#Time complexity: O(1)
#Space complexity: O(1)
# Works on leetcode: yes
#Approach: We copy the next node's value to the node to be deleted and put it's next to next.next

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next