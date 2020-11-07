def deleteNode(curr_node):
    #code here
     prev = None

     if(curr_node == None):
        return
     else:
        while(curr_node.next != None):
            curr_node.data = curr_node.next.data
            prev = curr_node
            curr_node = curr_node.next

        prev.next = None
