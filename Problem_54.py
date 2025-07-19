'''
Delete without head pointer
Problem Link: https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
'''

# Time Complexity : O(1) as we are only modifying pointers and data
# Space Complexity : O(1) as we are not using any additional data structures
# Did this code successfully run on Leetcode : Yes, it runs successfully on GeeksforGeeks
# Any problem you faced while coding this : No, the logic is straightforward and works as expected.

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
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node): # humne node ko delete karna hai (we need to delete the given node)
        if node is None or node.next is None: # agar node khali hai ya next node None hai to hum kuch nahi karte (if the node is None or the next node is None, we do nothing)
            return
        # We cannot delete the last node in a singly linked list without a head pointer,
        # so we assume that the node to be deleted is not the last node.
        #code here
        node.data = node.next.data # hum current node ke data ko next node ke data se replace karte hain (we replace the current node's data with the next node's data)
        # We then skip the next node by pointing the current node's next to the next's
        node.next = node.next.next # node ke next ko next.next se point karte hain (we point the current node's next to the next's next node)
        # We copy the data from the next node to the current node
        # and then we skip the next node by pointing the current node's next to the next's next node.
        # This effectively deletes the current node from the linked list.
        # This approach works because we are guaranteed that the node to be deleted is not the last node in the list.
        # Thus, we can safely access node.next without worrying about it being None.
        # The time complexity is O(1) since we are only modifying pointers and data
        # The space complexity is O(1) since we are not using any additional data structures
        # This solution is efficient and works in constant time and space.