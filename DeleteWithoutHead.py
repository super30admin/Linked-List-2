# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Node:
	def __init__(self, data):   # data -> value stored in node
		self.data = data
		self.next = None
  
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if node is None:
            return
        if node.next is None:
            return
        node.data = node.next.data
        node.next = node.next.next