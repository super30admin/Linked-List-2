class DeleteNode {
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Approach: Copy the data of the next node to the current node and delete the next node.
    void deleteNode(Node node) {
        // Your code here
        node.data = node.next.data;
        node.next= node.next.next;

    }
}