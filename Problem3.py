#

def deleteNode(curr_node):
    #code here
    
    if not curr_node:
        return
    
    if not curr_node.next:
        curr_node = Node(None)
        return 
    
    curr_node.data = curr_node.next.data
    
    curr_node.next = curr_node.next.next