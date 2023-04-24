'''
Approach
--------
Here we use copy the next node's data to current node and move the next pointer to next's next 


Complexity Analysis
-------------------
TC = O(1) 
SC = O(1) not storing anything
'''


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next