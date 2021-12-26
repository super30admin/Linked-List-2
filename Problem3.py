#Time Complexity : O(1) - Not visiting more than 3 nodes
#Space Complexity : O(1) - Not storing or using any extra memory 

def deleteNode(self,curr_node):
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next