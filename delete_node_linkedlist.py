// Explain your approach in three sentences only at top of your code
// Approach: Since we do not have access to the head of the linked list, we copy the value of the next node into the current node. Then, we update the `next` pointer of the current node to skip the next node, effectively deleting it. This way, the node to be deleted is replaced and bypassed without needing the head reference.

// Time Complexity : O(1), as the operation is performed in constant time.
// Space Complexity : O(1), as no extra space is used.
// Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution:
    # Function to delete a node without any reference to the head pointer.
    def deleteNode(self, del_node):
        # Copy the data from the next node into the current node.
        del_node.data = del_node.next.data

        # Update the next pointer to skip the next node, effectively deleting it.
        del_node.next = del_node.next.next
