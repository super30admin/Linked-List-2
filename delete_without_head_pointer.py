""" 
You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given. 
Note: No head reference is given to you. It is guaranteed that the node to be deleted is not a tail node in the linked list.

Time Complexity: O(1)
Space Complexity: O(1)
"""

def deleteNode(curr_node):
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next