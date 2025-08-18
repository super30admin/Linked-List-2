# Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: We can copy the data of the next node to the data field of the current node to be deleted. Then we can move one step forward. Now our next has become the current node and the current has become the previous node. Now we can easily delete the current node by conventional deletion methods

# Node Class
class Node:
    def __init__(self, data):
        self.data = data
		self.next = None
class Solution:
    def deleteNode(self, del_node):
        if del_node is None:
            return
        if del_node.next is None:
            print("This is the last node, requires head, cant be freed")
            return
        
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next
        