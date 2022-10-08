#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val # copying next node value in the current node.
        node.next = node.next.next # to delete the next node that we copied, we are updating the reference of the node to next to next node.
 