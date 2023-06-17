# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# In order to delete the current node, since we dont have access to the previous node, 
# we just copy over the next node's value into this node and delete the next node.
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        if not curr_node.next:
            return
        next_node = curr_node.next
        curr_node.data = next_node.data
        curr_node.next = next_node.next
        next_node.next = None