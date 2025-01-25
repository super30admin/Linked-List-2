/*
Time Complexity -> O(1)
Space Complexity -> O(1)
*/


class Solution1 {
    void deleteNode(Node node) {
        // Your code here
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
