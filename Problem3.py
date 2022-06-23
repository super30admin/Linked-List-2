'''
Time Complexity: O(1)
Space Complexity: O(1)
Run on GeeksforGeeks: YES
'''
class Node:
    def __init__(self, data=0):
        self.data = data
        self.next = None

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node: Node):
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next