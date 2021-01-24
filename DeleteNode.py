# # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        temp = node.next # Storing the next node of the node to be deleted into temp so that later we can make its next to None
        node.val = node.next.val # over writing the next value on the node which we wanat to delete
        node.next = node.next.next # Now we can connect the node to its node.next.next to get rid of node.next since its value is
                                    # is already copied to node
        temp.next = None # node.next to None
        
        