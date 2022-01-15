# TC : O(1)
# SC: O(1)

class Node:
            def __init__(self, data):   # data -> value stored in node
                self.data = data
                self.next = None

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        
        new_node = Node(curr_node.next.data)
        new_node.next = curr_node.next.next
        curr_node.data = new_node.data
        curr_node.next = new_node.next