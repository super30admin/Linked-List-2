# Approach: We are not given the head of the linked list so we can use the next pointer to delete the node
# Time: O(N)
# Space: O(1)

def deleteNode(self, node):

    node.val = node.next.val
    node.next = node.next.next