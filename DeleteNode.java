// Time complexity :O(1)
// Space Complexity :O(1)
class Solution {
    void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }
}