# Runs on Geeks for Geeks


def deleteNode(curr_node):
    if curr_node is not None:
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
