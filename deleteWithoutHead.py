# // Time Complexity : O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach


class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        
        if not node or not node.next:   # if empty 
            return None
        
        node.data = node.next.data      # replace value
        node.next = node.next.next      # replace pointer
