"""
Time: O(1)
Space: O(1)
Geeks : Accepted
Problems: Nope
"""


def deleteNode(curr_node):
    if curr_node is None:
        #if None do nothing
        pass
    elif curr_node.next:
        #otherwise copy next's data and pointer into node
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
    else:
        #if node is last node just set it to None
        curr_node = None
