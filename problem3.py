class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        prev = Node(1)
        if curr_node == None:
            return
        while(curr_node.next!=None):
            curr_node.data = curr_node.next.data
            prev = curr_node
            curr_node = curr_node.next

        prev.next = None
