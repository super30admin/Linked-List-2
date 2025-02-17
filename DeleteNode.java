// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Copy the data of the next node to the current node
// 2. Delete the next node


// Function to delete a node without any reference to head pointer.
class DeleteNode {
    void deleteNode(Node node) {
        // Your code here
        if(node == null){
            return;
        }

        Node temp = node.next;
        node.data = node.next.data;
        node.next = node.next.next;
        temp.next = null;
    }
}
