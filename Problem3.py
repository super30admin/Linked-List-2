#Time complexity is: O(1)
#Space complexity is: O(1) 
#Code ran successfully on geeks for geeks
#Faced no issues while coding this problem

#User function Template for python3
'''
    Your task is to delete the given node from
	the linked list, without using head pointer.
	
	Function Arguments: node (given node to be deleted) 
	Return Type: None, just delete the given node from the linked list.

	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        #We will be initialising a temp pointer to the next of curr_node
        temp=curr_node.next
        #We are moving the data of temp to curr_node
        curr_node.data=temp.data
        #We will be pointing curr_node.next to curr_node.next.next
        curr_node.next=temp.next
        #Clearing the curr_node
        del curr_node
#Driver code