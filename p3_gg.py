# Delete without head pointer

# TC : O(1) - All operations take constant time regardless of list size
# SC : O(1) - We only use a constant amount of extra space
# Did this code successfully run on GG : YES

# Approach:
# The key insight to this problem is that since we can't access the previous node (which we'd typically need for deletion), we can instead:
    # Copy the value: Take the value from the next node and overwrite our current node's value
    # Bypass the next node: Update our node's next pointer to skip over the next node


def deleteNode(del_node):
    # Step 1: Get the next node
    next_node = del_node.next
    
    # Step 2: Copy the data from the next node to our deletion node
    del_node.data = next_node.data
    
    # Step 3: Update the next pointer to skip the next node
    del_node.next = next_node.next
    