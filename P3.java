/*
Time Complexity: O(1), as no traversal is required.
Space Complexity: O(1), no extra space is used.
 */

class Solution {
    void deleteNode(Node node) {
        // Your code here
        if (node == null || node.next == null) {
            return;
        }
        
        Node nextNode = node.next;
        node.data = nextNode.data;
        
        node.next = nextNode.next;
    }
}