# Time Complexity : O(1) — we perform a constant number of operations (no traversal).
# Space Complexity : O(1) — we use no extra space.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding how to delete a node 
# without having access to the previous node.


# Your code here along with comments explaining your approach
class Solution:
    def deleteNode(self, del_node):
        """
        Delete the given node from a singly linked list when 
        head of the list is not provided.
        """
        # Copy the data from the next node into the current node
        del_node.data = del_node.next.data

        # Skip the next node by pointing current node's next 
        # to the node after the next one
        del_node.next = del_node.next.next
