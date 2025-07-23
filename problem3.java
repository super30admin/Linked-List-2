//Time Complexity: O(1) — constant-time operation to copy and re-link nodes.
//Space Complexity: O(1) — no extra space used.

//Copy the data from the next node into the current node.
//Bypass the next node by pointing current’s next to next.next.

class Solution {
    public void deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            // Cannot delete the node if it's the last node
            return;
        }

        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}
