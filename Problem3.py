'''
1. Modify the nodes value to its next value
2. Make this node point to its next node's next

TC: O(1)
SC: O(1)
'''

def deleteNode(node):
    node.val = node.next.val
    node.next = node.next.next