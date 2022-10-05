#delete without head pointer
#tc:O(1)
#sc:O(1)
def deleteNode(self,curr_node):

        nextnode=curr_node.next

        nextnode_data=curr_node.next.data

        nextnode_next=curr_node.next.next

        curr_node.data=nextnode_data

        curr_node.next=nextnode_next

        

        del nextnode