# Author: Naveen US
# Title: Delete without head pointer

# Time complexity: O(n)
# Space complexity: O(1)
# Did the code run on leetcode: Yes
class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
          
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        ns = curr_node
        ns.data = ns.next.data
        ns.next = ns.next.next
        del curr_node
