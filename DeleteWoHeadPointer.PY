class Node:
    def __init__(self, data): 
        self.data = data
        self.next = None


class DeleteWithoutHead(object):
    def deleteNode(self, curr_node):
        if (curr_node == None or curr_node.next == None):
            return None

        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next

        return

