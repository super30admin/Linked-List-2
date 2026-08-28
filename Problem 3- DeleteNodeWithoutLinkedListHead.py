#Time Complexity: O(1)
#Space Complexity: O(1)

''' Structure of Linked List Node
		class Node:
		    def __init__(self, data):  
		        self.data = data
		        self.next = None
'''
class Solution:
    def deleteNode(self, x):
        # code here
        if del_node is None or del_node.next is None:
            return

        del_node.data = del_node.next.data
        del_node.next = del_node.next.next
        