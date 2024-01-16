""" Explanation: The deleteNode function copies the value of the next node to the current node, 
    essentially replacing the current node's value with the next node's value.
    It then updates the current node's next pointer to skip the next node, effectively removing 
    the next node from the linked list.
    Time Complexcity: O(1) since it directly modifies the node to be deleted rather than iterating
    Space Complexcity: O(1)
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def deleteNode(node_to_delete):
    if not node_to_delete or not node_to_delete.next:
        # Invalid input or cannot delete the last node using this method
        return

    # Copy the value of the next node to the current node
    node_to_delete.val = node_to_delete.next.val

    # Update the current node's next pointer to skip the next node
    node_to_delete.next = node_to_delete.next.next

