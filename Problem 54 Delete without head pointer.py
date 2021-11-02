# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(1)
# Space Complexity: O(1)
# Logic: add the value of next node to the current node to make them identical, now we have both prev & current as same
# nodes, delete the node.

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self, curr_node):
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
        curr_node = None
