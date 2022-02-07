#Delete Without Head Pointer

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        curr_node.val = curr_node.next.val
        curr_node.next = curr_node.next.next

# T.C => O(1) // since we are just need to deal with the current node and the node next to it
# S.C => O(1)

# Approach => 1. set the current node value to the next node value.
# 2. Then point the current node to the next of next node 

