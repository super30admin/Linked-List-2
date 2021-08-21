"""
Time complexity: O(1)
Space complexity: O(1)
Approach: Given that the node to delete will not be the tail node, copy value of next node in given node
        then node.next = node.next.next

"""
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next