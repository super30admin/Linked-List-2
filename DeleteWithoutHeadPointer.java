// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    void deleteNode(Node del_node) {
        // Your code here
        del_node.data = del_node.next.data;
        Node temp = del_node.next;
        del_node.next = del_node.next.next;
        temp = null;
    }
}