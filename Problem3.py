## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
''' Structure of linked list Node
	{
		class Node:
		    def __init__(self, data):  
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    def deleteNode(self, del_node):
        # code here
        temp = del_node.next
        del_node.data = temp.data
        del_node.next = temp.next