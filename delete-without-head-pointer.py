class Solution:
    # Function to delete a node in the middle of a singly linked list.
    #Time Complexity : The time complexity remains O(1) since we only modify two pointers
    #Space Complexity : O(1)
    def deleteNode(self, node):
        #code here
        #If the input is empty
        if(Node==None):
            return
        node.data = node.next.data
        node.next = node.next.next