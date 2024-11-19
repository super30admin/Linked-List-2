class Solution:
    def deleteNode(self, node: ListNode) -> None:
        """
        Deletes the given node without access to the head of the list.
        """
        if not node or not node.next:
            return  # Cannot delete the node if it is the last one or invalid
        
        # Step 1: Copy the value from the next node to the current node
        node.val = node.next.val
        
        # Step 2: Bypass the next node
        node.next = node.next.next