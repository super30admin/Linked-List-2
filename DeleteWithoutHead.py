# TC & SC: O(1)
# The reference of a node is given- we can delete without head pointer. Cant do it for last node. 
def delete(node):
    if node == None or node.next== None: return
    # copy next node value
    node.val = node.next.val
    # bypass repeat node value
    node.next = node.next.next
    