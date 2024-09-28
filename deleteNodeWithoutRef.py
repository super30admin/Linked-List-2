# Approach: We are not given the head of the linked list so we can use the next pointer to delete the node
# Brute Force - In usual cases we use a prev pointer to follow current node and remove it 
    # case 1 - removing head ndoe - update self.head = current.next
    # case 2 - removing other nodes --- prev.next == current.next
    # For these we had to iterate on LL up until the point we find the value to delete

# Here the ref to the node we need to delete is given so just update the node's val with next node's val and re wire pointers to next next
# Time: O(N)
# Space: O(1)

def deleteNode(self, node):

    node.val = node.next.val
    node.next = node.next.next