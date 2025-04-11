# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, on GFG
# Any problem you faced while coding this : No

# Approach:
# 1. Check if the node to be deleted is None or if it is the last node in the list.
# 2. If it is the last node, return as we cannot delete it.
# 3. Create a temporary node to hold the next node's data.
# 4. Copy the data from the next node to the current node.
# 5. Update the current node's next pointer to skip the next node.

# Node Class
class Node:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if not node.next:
            return
        
        tmp = node.next
        node.data = tmp.data
        node.next = tmp.next
        del tmp