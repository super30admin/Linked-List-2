"""
TC: O(1) {we dont use a loop or any iteration to delete the node}
SC: O(1) {we don't use any extra space}

Approach:

We get the node to del and swap its value with its immediate next node. By doing so, we now have the node to del at the tracable node
ie we have a prev node to that.
Then we just remove the ptr of the node to del from the list and let the garbage collection collect the deleted node.

The problem ran successfully on GeeksForGeeks.
"""

# Node Class
class Node:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None

class Solution:
    def deleteNode(self, del_node):
        # code here
        curr = del_node
        
    
        
        if curr.next:
            curr.data = curr.next.data
            curr.next = curr.next.next
        
        