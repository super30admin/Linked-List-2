// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We copy the delete node's next value to delete node. And we point the delete node to next's next node to skip the node that is not needed anymore.
 */
class Solution {
    public void deleteNode(Node del_node) {
        // if node to be deleted is null
        if (del_node == null)
            return;
        // if node to be deleted has no next node, then we can make the delete node to be null so that it will be deleted
        if (del_node.next == null) {
            del_node = null;
            return;
        }

        Node temp = del_node.next;
        del_node.data = temp.data;
        del_node.next = temp.next;
        // unreferenced node
        temp = null;
    }
}