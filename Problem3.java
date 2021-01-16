//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted

// Time Complexity : O(1)
// Space Complexity : O(1)
class GfG {
    void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
