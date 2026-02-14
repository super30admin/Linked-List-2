/*
Approach: We cannot delete the given node directly because 
We cannot access the previous node. So we can copy the next node’s 
data into the current node and remove the next node instead.
*/

// Time: O(1)
// Space: O(1)

// yes code ran successfully on GeeksforGeeks

class Solution {
    public void deleteNode(Node del_node) {

        if (del_node == null || del_node.next == null) {
            return;   // safety check, last node is never given as per constraint
        }

        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}
