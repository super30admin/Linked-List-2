"""
You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given. 
Note: No head reference is given to you.

time = O(n), space = O(1)
Approach -- 
1. Copy the value of next into current node
2. Point node.next to node.next.next

"""

class DeletNpde:
    def deleteNode(self, node):
        
        node.val = node.next.val
        node.next = node.next.next