// Time Complexity O(1)
// Space Complexity O(1)
// Runs on LeetCode YES

/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

// Function to delete a node without any reference to head pointer.
class DeleteWithoutHead {
    void deleteNode(Node node) {
        // Your code here
        Node nextNode = node.next;

        node.data = nextNode.data;

        node.next = nextNode.next;

        nextNode.next = null;
    }
}
