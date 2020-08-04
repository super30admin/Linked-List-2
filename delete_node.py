def deleteNode(curr_node):
    if curr_node is None:
        return
    
    if curr_node.next is None: 
        curr_node.data = None
        return

    elif curr_node.next.next is None:
        curr_node.data=curr_node.next.data
        curr_node.next=None
        return

    curr_node.data = curr_node.next.data
    deleteNode(curr_node.next)
#Time-Complexity:O(N)
#Space-Complexity: O(1)